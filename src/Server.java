import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.PORT)) {
            System.out.println("start server");

            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("Connect client from port " + clientSocket.getPort());
                    writer.println("hi from server");
                    //writer.flush();

                    System.out.println(reader.readLine());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
