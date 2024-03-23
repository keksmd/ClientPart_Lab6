package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
            CollectionManager.collection.stream().filter(SpaceMarine::getLoyal).forEach(System.out::println);
            CollectionManager.collection.stream().filter(w-> !w.getLoyal()).forEach(System.out::println);
            return resp;

    }
}
