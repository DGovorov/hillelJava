package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by User on 26.04.2016.
 */
public class MessageHandler implements Runnable{

    private Socket socket;

    public MessageHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                Socket socket = this.socket;
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){
            while (true) {
                String message = reader.readLine();
                if (message == null) {
                    break;
                }
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " " + message);
            }
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
        System.out.println("handler stops");
    }
}
