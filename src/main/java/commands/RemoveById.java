package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class RemoveById extends Command implements methods{
    final String idToRemove;
    public RemoveById(String id){
        this.idToRemove = id;
    }
    public Response calling(){
        Response resp = super.calling();
        if(CollectionManager.collection.stream().anyMatch(w->String.valueOf(w.getId()).equals(idToRemove))) {
            CollectionManager.collection.removeIf(c -> c.getId() == Integer.parseInt(idToRemove));

        }else{
            resp.addMessage("Ошибка, не существует элемента с таким ID");
            resp.setSuccess(false);

        }
        return resp;
    }

}
