package Assignment27;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (true) {
            System.out.print("Client: ");
            msg = console.readLine();
            out.println(msg);
            if (msg.equalsIgnoreCase("bye")) break;
            System.out.println("Server: " + in.readLine());
        }
        s.close();
    }
}