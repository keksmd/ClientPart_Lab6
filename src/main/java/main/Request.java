package main;

import commands.utilites.Command;

import java.lang.reflect.Field;

public class Request extends Message{
    public Request(){

    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("***** ").append(this.getClass()).append(" Details *****\n");
        for(Field f: this.getClass().getFields()){
            try {
                f.setAccessible(true);
                if (f.get(this) == null) {
                    s.append(f.getName()).append("=").append("null").append("\n");
                }else{
                    s.append(f.getName()).append("=").append(f.get(this).toString()).append("\n");
                }            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s.append("*****************************");

        return s.toString();
    }
    Command commandToExecute;
    public Command getCommandToExecute() {
        return commandToExecute;
    }

    public void setCommandToExecute(Command commandToExecute) {
        this.commandToExecute = commandToExecute;
    }

}
