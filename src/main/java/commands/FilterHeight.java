package commands;

import main.Command;
import main.Message;
import main.Request;
import utilites.interfaces.methods;

public class FilterHeight extends Command implements methods{
    final int limit;
    @Override
    public String toString() {
        return super.toString();
    }
    public FilterHeight(int l){
        this.limit = l;
    }
    public Request calling(){
        Request resp = super.calling();
        this.setArgs(new String[]{String.valueOf(limit)});
       return resp;
    }
}
