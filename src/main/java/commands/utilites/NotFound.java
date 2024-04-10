package commands.utilites;

import commands.types.NoArgumented;

public class NotFound extends NoArgumented {
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "not_found" ;
}
