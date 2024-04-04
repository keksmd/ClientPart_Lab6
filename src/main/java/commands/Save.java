package commands;

import main.Command;
import utilites.interfaces.methods;


public class Save extends Command implements methods{
    private String name = "save" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}