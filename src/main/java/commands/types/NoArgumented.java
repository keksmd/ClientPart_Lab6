package commands.types;

import commands.noArgumentable;
import commands.utilites.Command;

public class NoArgumented extends Command implements noArgumentable {
    public NoArgumented(){
        super(null,null);
    }
    public static NoArgumented newInstance(String v, String[] args){
        return new NoArgumented().elFactory(v,args);
    }

    @Override
    public NoArgumented elFactory(String v, String[] args) {
        return new NoArgumented();
    }

    @Override
    public NoArgumented elFactory() {
        return null;
    }
}
