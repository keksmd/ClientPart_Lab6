package commands;

import main.Command;
import main.Message;
import main.Request;
import utilites.interfaces.methods;

public class RemoveById extends Command implements methods{
    @Override
    public String toString() {
        return super.toString();
    }
    final String idToRemove;
    public RemoveById(String id){
        this.idToRemove = id;
    }
    public Request calling(){
        Request resp = super.calling();
        setArgs(new String[]{idToRemove});

        return resp;
    }

}
