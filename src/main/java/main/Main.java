package main;

import commands.utilites.CommandMapper;
import commands.utilites.NotFound;
import exceptions.LOLDIDNTREAD;
import utilites.Context;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import static commands.utilites.Command.commandReader;
import static commands.utilites.CommandMapper.setCommands;
import static utilites.ServerMessaging.nioRead;
import static utilites.ServerMessaging.nioSend;


public class Main {
    private Main() {
    }

    private final static Set<String> wasExecuted = new HashSet<>();

    public static Set<String> getWasExecuted() {
        return wasExecuted;
    }
    static SocketChannel socketChannel;

    public static boolean flag = true;
    private  static void setConnection(){
        boolean flag = true;
        while (flag) {
            try {
                flag = false;
                InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8081);

                //InetSocketAddress  socketAddress = new InetSocketAddress(InetAddress.getByName("helios.cs.ifmo.ru"),8081);
                socketChannel = SocketChannel.open(socketAddress);

                //socketChannel.write(ByteBuffer.wrap("QkfR<6584".getBytes()));
            } catch (ConnectException e) {
                flag = true;
                e.printStackTrace();
                System.out.println("Не удалось подключиться к серверу,введите любую строку,чтобы попробовать еще раз");
                new Scanner(System.in).nextLine();
            } catch (IOException e) {
                flag = true;
                e.printStackTrace();
                System.out.println("Не удалось подключиться к серверу,введите любую строку,чтобы попробовать еще раз");
                new Scanner(System.in).nextLine();
            }
        }
    }

    public static void main(String[] args) {
        setConnection();
        setCommands(socketChannel);
        System.out.println("доступные команды и их типы \n"+CommandMapper.nameToTypeMap);

            //while (flag) {
                try {
                    new SendingThread().start();
                    new ReadingThread().start();


                } catch (NoSuchElementException e) {
                    System.err.println("Не надо вводить ctrl+D !!!");
                    System.exit(0);
                }
           // }


    }
    public static void executeNext(Scanner s) throws IOException{
        Request req = null;

        String line;
        while(req==null) {
            line = s.nextLine();
            req = commandReader(line,new Context(new Scanner(System.in))).calling();//прогоняем через кастрированую систему команд,инициализируя commandToExecute и принимая аргументы в ее args
            if(req.commandToExecute instanceof NotFound){
                System.out.println("Unknown command,try again or use 'help' toget information about aviable commands");
                req= null;
            }
        }
        req.addMessage(req.commandToExecute.getName());
        nioSend(socketChannel,req);
    }
    public static void getAnswerFromServer(){
        Response response = null;

        try {
            response = nioRead(socketChannel);
        } catch (IOException | LOLDIDNTREAD ignored) {
        }
        if (response != null) {
            if (!response.getMessages().isEmpty()) {
                response.getMessages().forEach(System.out::println);
                flag = response.isFlag();
            }

        }
    }


}