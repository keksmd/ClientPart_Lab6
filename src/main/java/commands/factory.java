package commands;

import commands.utilites.Command;
@FunctionalInterface

public interface factory {
    public Command elFactory(String v, String[] args);
}
