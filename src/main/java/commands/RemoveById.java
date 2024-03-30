package commands;

import main.Command;
import main.Request;
import utilites.interfaces.methods;

public class RemoveById extends Command implements methods{
    final String idToRemove;
    public RemoveById(String id){
        this.idToRemove = id;
    }
    public Request calling(){
        Request resp = super.calling();
        setArgs(new String[]{idToRemove});

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

    private String name = "remove_by_id" ;

}