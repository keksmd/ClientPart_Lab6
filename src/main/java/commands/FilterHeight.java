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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "filter_grater_then_height" ;
    public FilterHeight(int l){
        this.limit = l;
    }
    public Request calling(){
        Request resp = super.calling();
        this.setArgs(new String[]{String.valueOf(limit)});
       return resp;
    }
}
