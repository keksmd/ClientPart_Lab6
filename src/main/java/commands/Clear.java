package commands;

import main.*;
import utilites.interfaces.*;

public class Clear extends Command implements methods{
    public Request calling(){
        Request resp = super.calling();
        return resp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "clear" ;

    public Clear(){

    };
}
