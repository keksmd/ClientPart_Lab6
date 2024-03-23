package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class FilterHeight extends Command implements methods{
    final int limit;
    public FilterHeight(int l){
        this.limit = l;
    }
    public Response calling(){
        Response resp = super.calling();
        CollectionManager.collection.stream().filter(w->w.getHeight()>limit).forEach(System.out::println);
        return resp;
    }
}
