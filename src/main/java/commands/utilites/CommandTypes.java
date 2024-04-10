package commands.utilites;

import commands.types.ElementAndValueArgumented;
import commands.types.ElementArgumented;
import commands.types.NoArgumented;
import commands.types.ValueArgumented;

public enum CommandTypes {
    ELEMENT_AND_VALUE_ARGUMENTED(ElementAndValueArgumented::newInstance),
    ELEMENT_ARGUMENTED(ElementArgumented::newInstance),
    VALUE_ARGUMENTED(ValueArgumented::newInstance),
    WITHOUT_ARGUMENTS(NoArgumented::newInstance);
    final commands.factory factory;

    public commands.factory getFactory() {
        return factory;
    }

    CommandTypes(commands.factory f) {
        this.factory = f;
    }

}
