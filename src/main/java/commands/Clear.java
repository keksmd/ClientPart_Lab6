package commands;

import main.*;
import utilites.interfaces.*;

public class Clear extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        CollectionManager.collection.clear();
        return resp;
    }
}
