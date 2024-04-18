package commands;

import commands.utilites.Command;
@FunctionalInterface

public interface IFactory {
    Command elFactory(String v, String[] args);
}
