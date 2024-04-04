package commands;

import main.Request;
import utilites.interfaces.methods;

import java.util.Arrays;
import java.util.stream.Stream;

import static utilites.CheckingReader.checkyRead;

public class UpdateById extends ElementArgumentable implements methods{
    private final String idToUpdate;

    public UpdateById(String id){
        this.idToUpdate = id;
    }
    private String name = "update_by_id" ;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Request calling(){
        Request resp = super.calling();
        this.setArgs(
                Stream.concat(
                        Stream.of(
                                idToUpdate),
                        Arrays.stream(this.getArgs())
                        ).toArray(String[]::new));
        return resp;
    }
}
