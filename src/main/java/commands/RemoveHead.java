package commands;

import main.Command;
import utilites.interfaces.methods;

public class RemoveHead extends Command implements methods{
    private String name = "remove_head" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
