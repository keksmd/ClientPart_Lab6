package commands;

import main.Command;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends Command implements methods{

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "print_field_descending_loyal" ;



}
