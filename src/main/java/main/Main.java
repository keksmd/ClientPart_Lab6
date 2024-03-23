package main;

import exceptions.Discntcd;
import exceptions.LOLDIDNTREAD;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static utilites.ServerMessaging.nioRead;
import static utilites.ServerMessaging.nioSend;


public class Main {
    public static boolean flag = true;

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            // InetSocketAddress  socketAddress = new InetSocketAddress("s374052@helios.cs.ifmo.ru",2222);
            InetSocketAddress  socketAddress = new InetSocketAddress("localhost",8081);
            SocketChannel socketChannel = SocketChannel.open(socketAddress);

            while (flag) {
                try {
                    String readed = sc.nextLine();
                    System.out.println(readed);
                    nioSend(socketChannel, readed);
                    Response response;
                    try {
                        response = nioRead(socketChannel);
                    } catch (IOException | LOLDIDNTREAD | Discntcd e) {
                        response = null;
                        if (e instanceof Discntcd) {
                            socketChannel.close();
                        }
                    }
                    if (response != null) {
                        if (!response.getMessages().isEmpty()) {
                            for (String msg : response.getMessages()) {
                                System.out.println(msg);
                            }
                        }
                        flag = response.isFlag();
                    }

                } catch (NoSuchElementException e) {
                    System.err.println("Не надо вводить ctrl+D !!!");
                    System.exit(0);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}