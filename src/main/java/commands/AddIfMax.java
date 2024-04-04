package commands;


import main.Request;
import utilites.interfaces.methods;

import static utilites.CheckingReader.checkyRead;

public class AddIfMax extends ElementArgumentable implements methods{
    public AddIfMax(){

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "add_if_max" ;
    public Request calling() {
        Request resp = super.calling();


        return resp;
    }
}
