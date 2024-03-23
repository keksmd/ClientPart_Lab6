package commands;

import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class WrongArguments extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        resp.addMessage("Wrong number or type of arguments, while creating object, you needed 4 arguments: String name,long health,Boolean loyal,float height and some additional in next lines %n");
        resp.setSuccess(false);
        return resp;
    }
}
