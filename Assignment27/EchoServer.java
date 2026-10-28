package Assignment27;
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6000);
        System.out.println("Echo server started...");
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Received: " + msg);
            out.println(msg);   // send same message back
        }
        s.close();
        ss.close();
    }
}