package main;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Response {
    private boolean success;
    ArrayList<String> messages = new ArrayList<>();
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("***** Response Details *****\n");
        for(Field f:Response.class.getFields()){
            try {
                f.setAccessible(true);
                s.append(f.getName()).append("=").append(f.get(this).toString()).append("\n");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s.append("*****************************");

        return s.toString();
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public Response() {
    }
    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }
    public void addMessage(String msg1){
        this.messages.add(msg1);
    }

}
