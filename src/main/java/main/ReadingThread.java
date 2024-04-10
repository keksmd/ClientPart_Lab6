package main;

import exceptions.LOLDIDNTREAD;

import java.io.IOException;

import static main.Main.*;
import static utilites.ServerMessaging.nioRead;

public class ReadingThread extends Thread{
    @Override
    public void run() {
        while ((flag)) {
            getAnswerFromServer();

        }
    }

}
