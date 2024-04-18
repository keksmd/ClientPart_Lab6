package commands;

import commands.types.ElementAndValueArgumented;

public interface ElementAndValueArgumentable extends IFactory {
    ElementAndValueArgumented elFactory(String v, String[] args);


}
