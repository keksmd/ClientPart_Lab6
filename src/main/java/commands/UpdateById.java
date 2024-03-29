package commands;

import main.Command;
import main.Message;
import main.Request;
import utilites.interfaces.methods;

import static utilites.CheckingReader.checkyRead;

public class UpdateById extends Command implements methods{
    private final String idToUpdate;
    @Override
    public String toString() {
        return super.toString();
    }
    public UpdateById(String id){
        this.idToUpdate = id;
    }
    private String name = "update_by_id" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Request calling(){
        Request resp = super.calling();
        this.setArgs(
                new String[]{idToUpdate,
                (String) checkyRead("s","more length 0","Введите имя","sin"),
               String.valueOf((Long) checkyRead("l", "less than 626", "Введите целочисленную x-координату(x<=625","Sin")),
               String.valueOf((Float) checkyRead("f", "more than -353.0", "Введите y-координату в формате деcятичной дроби(y>=-354.0","sin")),
               String.valueOf((Long)checkyRead("l","more than 0","Введите здоровье","sin")),
               String.valueOf((Boolean) checkyRead("b","Введите булевое значение true/false преданности","sin")),
               String.valueOf((Float)checkyRead("f","Введите десятичное число,характеризующее длинну","sin")),
               String.valueOf((String) checkyRead("s","is weapon", """
                        Введите одно из названия для оружия:
                            BOLT_PISTOL,
                            COMBI_PLASMA_GUN,
                            GRENADE_LAUNCHER,
                            INFERNO_PISTOL,
                            MULTI_MELTA""","sin")),
               String.valueOf((String) checkyRead("s","more length 0", "Введите название главы","sin")),
               String.valueOf((String) checkyRead("s","more length 0", "Введите название мира","sin"))});
        return resp;
    }
}
