package commands;

import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class NotFound extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        resp.addMessage("Unknown command,try again or use 'help' toget information about aviable commands");
        resp.setSuccess(false);
        return resp;
    }
}
