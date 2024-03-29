package commands;

import main.*;
import utilites.interfaces.*;
public class Help extends Command implements methods {
    @Override
    public String toString() {
        return super.toString();
    }
    private String name = "help" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
