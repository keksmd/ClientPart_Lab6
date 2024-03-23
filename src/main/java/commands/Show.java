package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class Show extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        if(CollectionManager.collection.isEmpty()){
            resp.addMessage("В коллекции нет элементов");
        }
        CollectionManager.collection.forEach(
                w -> resp.addMessage(w+"\n"));
        return resp;
    }
}
