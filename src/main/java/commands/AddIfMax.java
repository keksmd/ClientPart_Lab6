package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.Chapter;
import spacemarines.Coordinates;
import spacemarines.SpaceMarine;
import spacemarines.Weapon;
import utilites.Response;
import utilites.interfaces.methods;

import java.util.Comparator;

import static utilites.CheckingReader.checkyRead;

public class AddIfMax extends Command implements methods{
    public AddIfMax(){

    }
    public Response calling() {
        Response resp = super.calling();

        resp.addMessage(String.format("add_if_max %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,",
                String.valueOf((String) checkyRead("s", "more length 0", "Введите имя", "sin")),
                String.valueOf((Long) checkyRead("l", "less than 626", "Введите целочисленную x-координату (x<=625)", "sin")),
                String.valueOf((Float) checkyRead("f", "more than -353.0", "Введите y-координату в формате деcятичной дроби (y>=-354.0)", "sin")),
                String.valueOf((Long) checkyRead("l", "more than 0", "Введите здоровье", "sin")),
                String.valueOf((Boolean) checkyRead("b", "Введите булевое значение true/false преданности", "sin")),
                String.valueOf((Float) checkyRead("f", "Введите десятичное число,характеризующее длинну", "sin")),
                (String) checkyRead("s", "is weapon", """
                        Введите одно из названия для оружия:
                            BOLT_PISTOL,
                            COMBI_PLASMA_GUN,
                            GRENADE_LAUNCHER,
                            INFERNO_PISTOL,
                            MULTI_MELTA""", "sin"),
                (String) checkyRead("s", "more length 0", "Введите название главы", "sin"),
                (String) checkyRead("s", "more length 0", "Введите название мира", "sin")));
        return resp;
    }
}