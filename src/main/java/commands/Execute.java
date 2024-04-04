package commands;

import main.Command;
import main.Main;
import main.Request;
import utilites.CheckingReader;
import utilites.interfaces.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Execute extends Command implements methods{

    final String fileName;
    public Execute(String fileName){
        this.fileName = fileName;

    }


    private String name = "exeute" ;

    public String getFileName() {
        return fileName;
    }

    public Request calling(){
        Request resp = super.calling();
        File file = new File(fileName);
        if(file.exists()){
            if (!Main.getWasExecuted().add(fileName)){
                System.out.println("Ах ты шалунишка,не стоит делать рекурсионный вызов комманд, рекурсия была проинорирована");
            }else {
                Scanner fileContentScanner;
                try {
                    fileContentScanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }


                while (fileContentScanner.hasNextLine()) {
                        try {
                            Main.executeNext(fileContentScanner);
                        }catch (IOException ignored){

                        }
                }
            }

            return resp;

        }else{
            System.out.println("There is no file with choosen name");
            return resp;
        }
    }


}
