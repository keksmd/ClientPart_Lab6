package commands;


import main.Command;
import utilites.interfaces.methods;

public class Show extends Command implements methods{
    private String name = "show" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
