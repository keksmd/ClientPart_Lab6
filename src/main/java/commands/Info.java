package commands;

import main.Command;
import utilites.interfaces.methods;

public class Info extends Command implements methods{
    @Override
    public String toString() {
        return super.toString();
    }
    private String name = "info" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
