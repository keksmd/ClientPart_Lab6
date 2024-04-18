package commands;

import commands.types.ValueArgumented;

public interface ValueArgumentable extends IFactory {
    ValueArgumented elFactory(String value);
}
