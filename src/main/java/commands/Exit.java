package commands;

import main.*;
import utilites.interfaces.*;

public class Exit extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        resp.setFlag(false);
        new Save().calling();
        return resp;

    }
}
