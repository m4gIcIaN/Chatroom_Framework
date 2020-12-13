import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

// Creates a server for the chatroom to run on
public class Server {

    public Server(int port){
        try (ServerSocket server = new ServerSocket(port)){
            System.out.println("Server Created.");
            while (true){
                new Client(server.accept()).start();
                System.out.println("Client Accepted.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Server(50000);
    }
}
