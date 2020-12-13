import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Connection CLass
// Intreprets Input from the users
public class Connection {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        try (Socket socket = new Socket("localhost", 50000)) {
            System.out.println("Client Running.");
            BufferedReader inputs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message;

            System.out.println(inputs.readLine());
            message = input.nextLine();
            output.println(message);

            do {
                if (!message.equals("exit")){
                    System.out.println(inputs.readLine());
                    message = input.nextLine();
                    output.println(message);
                }
            } while (!message.equals("exit"));

            System.out.println("Connection Closing");
            socket.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
