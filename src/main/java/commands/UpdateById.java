package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

public class UpdateById extends Command implements methods{
    final String idToUpdate;
    public UpdateById(String id){
        this.idToUpdate = id;
    }
    public Response calling(){
        Response resp = super.calling();
        boolean flag = false;
        for(SpaceMarine c: CollectionManager.collection){
            if(c.getId() == Integer.parseInt(idToUpdate)){
                c.update();
                flag = true;
            }
        }
        resp.setSuccess(flag);
        return resp;
    }
}
