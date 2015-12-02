import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        /* enter our program.
         */

        new Main().enterServer();// to avoid any problems with static fields


    }

    public void enterServer() throws Exception {
        System.out.println("Server is started at port 6543");
        serverSocket = new ServerSocket(6543);// port number at which the server is running.
        //for accepting request from the client. ( calling the method ).
        acceptRequest();
    }

    private void acceptRequest() throws Exception {
        while (true) {
            /* accepting request from our client
            connection to client is in the form of socket which contain the stream for input and output.
             */
            Socket s = serverSocket.accept();// accept(); is apart of class ServerSocket
            ConnectionHandler ch = new ConnectionHandler(s);

            //ch is the thread, so we have to start our thread.
            ch.start();//Start is apart of class Thread which will call the run method automatically.
            continue;
        }
    }
}
