package commands.types;

import commands.NoArgumentable;
import commands.utilites.Command;

public class NoArgumented extends Command implements NoArgumentable {
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
