package main;

import java.io.IOException;
import java.util.Scanner;

import static main.Main.executeNext;
import static main.Main.flag;

public class SendingThread extends Thread{
    @Override public void run() {
        while (flag) {
            try {
                executeNext(new Scanner(System.in));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
