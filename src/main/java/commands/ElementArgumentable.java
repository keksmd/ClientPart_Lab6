package commands;

import main.Command;
import main.Request;
import utilites.CheckingReader;

import java.util.Scanner;

import static utilites.CheckingReader.readSomeArgs;

public class ElementArgumentable extends Command implements elementReadable {
    @Override
    public Request calling(){
        if(this.getArgs()==null||this.getArgs().length==0){
            throw new RuntimeException("Для методов ElementReasable нужно сначала добавить объект,а затем вызывать calling");
        }
        return super.calling();
    }

    private String[] readElement(Scanner sc) {
        return readSomeArgs(9,"s,l,f,l,b,f,s,s,s".split(","),sc,(
                        "Введите имя;" +
                                "Введите целочисленную x-координату (x<=625));" +
                                "Введите y-координату в формате деcятичной дроби (y>=-354.0);" +
                                "Введите здоровье;" +
                                "Введите булевое значение true/false преданности;" +
                                "Введите десятичное число,характеризующее длинну;" +
                                """
                                                Введите одно из названия для оружия:
                                                    BOLT_PISTOL,
                                                    COMBI_PLASMA_GUN,
                                                    GRENADE_LAUNCHER,
                                                    INFERNO_PISTOL,
                                                    MULTI_MELTA;""" +
                                "Введите название главы;"+
                                "Введите название главы;").split(";"),
                "more length 0;less than 626;more than -353.0;more than 0;;;is weapon;more length 0;more length 0".split(";"));
    }
    public void addElement(Scanner sc){
        this.setArgs(readElement(sc));
    }
}
