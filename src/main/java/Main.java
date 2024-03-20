import com.fasterxml.jackson.core.type.TypeReference;
import utilites.Response;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static utilites.ObjectConverter.deserialize;
import static utilites.ServerMessaging.recieve;
import static utilites.ServerMessaging.send;


public class Main {
    public static boolean flag = true;

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            //Socket socket = new Socket("s374052@helios.cs.ifmo.ru",2222);
            Socket socket = new Socket("localhost",8081);

            while (flag) {
                try {
                    send(socket,sc.nextLine());
                    Response response =recieve(socket);

                    if(!response.getMessages().isEmpty()){
                        for(String msg:response.getMessages()){
                            System.out.println(msg);
                        }
                    }
                    flag= response.isFlag();

                }catch (NoSuchElementException e){
                    System.err.println("Не надо вводить ctrl+D !!!");
                    System.exit(0);
                }
            }
            socket.close();
            socket.getOutputStream().close();
            socket.getInputStream().close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}