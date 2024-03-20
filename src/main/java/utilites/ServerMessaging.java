package utilites;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerMessaging {
    public static void send(Socket socket,String message) throws IOException {
        OutputStream os = socket.getOutputStream();
        Response resp = new Response();
        resp.getMessages().add(message);
        os.write(ObjectConverter.toJson(resp).getBytes());
        os.write(-1);
    }
    public static Response recieve(Socket socket) throws IOException{
        InputStream is =  socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte b;
        while ((b = (byte)is.read())!=-1) {
            buffer.write(b);
        }
        return ObjectConverter.deserialize(buffer.toString(StandardCharsets.UTF_8), new TypeReference<Response>() {});


    }
}
