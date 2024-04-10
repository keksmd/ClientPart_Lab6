package commands;

import commands.types.ValueArgumented;

public interface valueArgumentable extends factory {
    public ValueArgumented elFactory(String value);
}
