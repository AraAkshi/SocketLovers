package Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args []){
        Socket socket = null;
        System.out.println("Please Enter Username");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        int portNo = 8080;

        try{
            socket = new Socket("localhost", portNo);
            Thread.sleep(1000);
            Thread server = new Thread(new ServerThread(socket));
            server.start();
        } catch (IOException e){
            System.err.println("Fatal Connection Error: ");
            e.printStackTrace();
        } catch (InterruptedException e){
            System.err.println("Fatal Connection Error: ");
            e.printStackTrace();
        }
    }
}