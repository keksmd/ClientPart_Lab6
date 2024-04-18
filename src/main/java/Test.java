import commands.utilites.Command;
import utilites.Context;

import java.util.Scanner;

import static commands.utilites.Command.extractCommand;

public class Test {
    public static void main(String[] args){
        //CommandMapper.setCommands(String.format("add,%s;save,%s", "ELEMENT_ARGUMENTED","WITHOUT_ARGUMENTS"));
        Command c = extractCommand("add", new Context(new Scanner(System.in)));
    }
}
