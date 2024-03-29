package main;

import exceptions.Discntcd;
import exceptions.IncorrectCommandUsing;
import exceptions.LOLDIDNTREAD;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import static utilites.ServerMessaging.nioRead;
import static utilites.ServerMessaging.nioSend;


public class Main {
    private final static Set<String> wasExecuted = new HashSet<>();

    public static Set<String> getWasExecuted() {
        return wasExecuted;
    }
    private static SocketChannel socketChannel;

    public static boolean flag = true;
    private  static void setConnection(){
        boolean flag = true;
        while (flag) {
            // InetSocketAddress  socketAddress = new InetSocketAddress("s374052@helios.cs.ifmo.ru",2222);
            InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8081);
            try {
                flag = false;
                socketChannel = SocketChannel.open(socketAddress);
            } catch (IOException e) {
                flag = true;
                System.out.println("Не удалось подключиться к серверу,введите любую строку,чтобы попробовать еще раз");
                new Scanner(System.in).nextLine();
            }
        }
    }

    public static void main(String[] args) {
        setConnection();
        try {
            while (flag) {
                try {
                    executeNext(new Scanner(System.in));
                } catch (NoSuchElementException e) {
                    System.err.println("Не надо вводить ctrl+D !!!");
                    System.exit(0);
                }
            }
        }catch (IOException e){
        }

    }
    public static void executeNext(Scanner s) throws IOException{
        Request req = null;
        boolean flag = false;
        String line = null;
        while(req==null) {
            line = s.nextLine();
            req = new Command().commandReader(line).calling();//прогоняем через кастрированую систему команд,инициализируя commandToExecute и принимая аргументы в ее args
        }
        req.addMessage(line);
        nioSend(socketChannel,req);
        Response response = null;
        try {
            response = nioRead(socketChannel);
        } catch (IOException | LOLDIDNTREAD | Discntcd e) {
            if (e instanceof Discntcd) {
                socketChannel.close();
            }
        }
        if (response != null) {
            if (!response.getMessages().isEmpty()) {
                    System.out.println(response.messages);
            }
            flag = response.isFlag();
        }
    }


}