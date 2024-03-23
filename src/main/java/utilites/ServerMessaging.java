package utilites;

import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.LOLDIDNTREAD;
import exceptions.Discntcd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;


public class ServerMessaging {

    public static Response nioRead(SocketChannel clientChannel) throws IOException, LOLDIDNTREAD, Discntcd {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int readed= clientChannel.read(buf);
        if (readed != -1) {
            buf.flip();
            return ObjectConverter.deserialize( new String(ByteBuffer.allocate(readed).put(buf.array(),0,readed).array()), new TypeReference<Response>() {});
        } else throw new LOLDIDNTREAD();
    }
    public static void nioSend(SocketChannel clientChannel,String message) throws IOException {
        Response resp = new Response();
        resp.addMessage(message);
        message =ObjectConverter.toJson(resp);
        System.out.println(message);
        ByteBuffer buf = ByteBuffer.allocate(message.length()).put(message.getBytes());
        buf = buf.flip();
        while (buf.hasRemaining()){
            clientChannel.write(buf);
        }
    }
    public static void nioSend(SocketChannel clientChannel,Response resp) throws IOException {
        String message = ObjectConverter.toJson(resp);
        ByteBuffer buf = ByteBuffer.allocate(message.length()).put(message.getBytes());
        buf = buf.flip();
        while (buf.hasRemaining()){
            clientChannel.write(buf);
        }
    }

}
