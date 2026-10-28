package Assignment27;
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 6000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msg;
        while (true) {
            System.out.print("Enter message (exit to quit): ");
            msg = console.readLine();
            if (msg.equalsIgnoreCase("exit")) break;
            out.println(msg);
            System.out.println("Server echoed: " + in.readLine());
        }
        s.close();
    }
}