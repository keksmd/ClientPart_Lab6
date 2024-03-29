package commands;

import main.Command;
import utilites.interfaces.methods;

public class NotFound extends Command implements methods{
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    private String name = "not_found" ;
}
