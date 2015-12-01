import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        new Main().runServer();
    }

    public void runServer() throws Exception {
        System.out.println("Server is started at port 6543");
        serverSocket = new ServerSocket(6543);
        acceptRequest();
    }

    private void acceptRequest() throws Exception {
        while (true) {
            Socket s = serverSocket.accept();
            ConnectionHandler ch = new ConnectionHandler(s);
            ch.start();
        }
    }
}
