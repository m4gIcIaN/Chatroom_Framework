import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{

    private Socket socket;
    private String userAlias;

    public Client(Socket sock){
        this.socket = sock;
    }

    @Override
    public void run(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter output = new PrintWriter(this.socket.getOutputStream(), true);

            output.println("What is your username?: ");
            this.userAlias = input.readLine();

            while (true) {
                output.println("Type a message: ");
                String message = input.readLine();
                System.out.println(this.userAlias +": "+ message);
            }

        } catch(Exception e) {
            System.out.println("Something went wrong with the client application");
        } finally {
            try {
                this.socket.close();
            } catch (IOException e){
                // Does nothing
            }
        }
    }
}
