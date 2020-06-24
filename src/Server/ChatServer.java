package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    static int portNo = 8080;
    static ServerSocket serverSocket;
    public static ArrayList<ClientThread> clients;

    public static void main(String args[]) {
        serverSocket = null;

        try {
            serverSocket = new ServerSocket(portNo);
        } catch (IOException e) {
            System.err.println("Could not listen on Port" + portNo);
            System.exit(1);
        }
    }

    public static void acceptClients(){
        clients = new ArrayList<ClientThread>();

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);

            } catch (IOException e){
                System.out.println("Accept failed on: " + portNo);
            }
        }
    }
}
