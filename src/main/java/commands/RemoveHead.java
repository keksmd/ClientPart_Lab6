package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class RemoveHead extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        CollectionManager.collection.poll();
        return resp;
    }
}
