package commands;

import main.*;
import utilites.interfaces.*;

public class Exit extends Command implements methods{

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "exit" ;
}
