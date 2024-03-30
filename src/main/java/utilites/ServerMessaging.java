package utilites;

import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.LOLDIDNTREAD;
import exceptions.Discntcd;
import main.Request;
import main.Response;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

//Client Messaging
public class ServerMessaging {

    public static Response nioRead(SocketChannel clientChannel) throws IOException, LOLDIDNTREAD {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int readed= clientChannel.read(buf);
        if (readed != -1) {
            buf.flip();
            String s = new String(ByteBuffer.allocate(readed).put(buf.array(),0,readed).array());

            return ObjectConverter.deserialize( s, new TypeReference<>() {});

        } else throw new LOLDIDNTREAD();
    }
    public static void nioSend(SocketChannel clientChannel,String message) throws IOException {
        Request resp = new Request();
        resp.addMessage(message);
        message =ObjectConverter.toJson(resp);
        ByteBuffer buf = ByteBuffer.allocate(message.getBytes().length).put(message.getBytes());
        buf = buf.flip();
        while (buf.hasRemaining()){
            clientChannel.write(buf);
        }
    }
    public static void nioSend(SocketChannel clientChannel, Request resp) throws IOException {
        String message = ObjectConverter.toJson(resp);
        ByteBuffer buf = ByteBuffer.allocate(message.getBytes().length).put(message.getBytes());
        buf = buf.flip();
        while (buf.hasRemaining()){
            clientChannel.write(buf);
        }
    }

}
