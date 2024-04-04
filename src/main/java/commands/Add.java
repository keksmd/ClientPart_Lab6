package commands;

import main.Request;

import static utilites.CheckingReader.checkyRead;

public class Add extends ElementArgumentable implements elementReadable{
    public Add(){
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    private String name = "add" ;


    public Request calling(){
        Request resp = super.calling();



        return resp ;

    }

}
