package Assignment27;
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting for client...");
        Socket s = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Client: " + msg);
            if (msg.equalsIgnoreCase("bye")) break;
            System.out.print("Server: ");
            out.println(console.readLine());
        }
        s.close();
        ss.close();
    }
}