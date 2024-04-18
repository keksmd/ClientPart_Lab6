package commands.utilites;

import exceptions.LOLDIDNTREAD;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.HashMap;

import static utilites.ServerMessaging.nioRead;
import static utilites.ServerMessaging.nioSend;

public class CommandMapper {
    private CommandMapper() {
    }

    public static HashMap<String,CommandTypes>  nameToTypeMap= new HashMap<>();

    public static void setCommands(SocketChannel chanel) throws IOException {
        chanel.configureBlocking(true);
            try {
                nioSend(chanel, "commands");
                String coded = nioRead(chanel).getMessages().get(0);
                Arrays.stream(coded.split(";"))
                        .forEach(w->nameToTypeMap.
                                put(w.split(",")[0],
                                        CommandTypes.valueOf(w.split(",")[1])));
            } catch (IOException | LOLDIDNTREAD ignored) {
            }
        chanel.configureBlocking(false);


    }

    private CommandMapper() {
    }


}
