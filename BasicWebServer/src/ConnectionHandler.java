import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by NathanStone on 11/28/15.
 */


public class ConnectionHandler extends Thread {
    // this class handles all the connection which contains the requests.
    //by extending class Thread, this class inherits Threads attributes.
    Socket s;
    PrintWriter pw;
    BufferedReader br;

    /*
    This constructor accepts a socket passed by acceptRequest();
     */

    public ConnectionHandler(Socket s) throws Exception {

        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream())); // used for collecting input from the client



        pw = new PrintWriter(s.getOutputStream());// is used to send output to the client
    }

    /*
    The thread class contains a method "run" which is called when we start the thread."

    In this method we have to read the request and give the response.

     */
    public void run() {
        try {

            /*
            Here we get the request as a string and give it to HTTP request class.
             */
            String reqS = "";
            while (br.ready() || reqS.length() == 0) //we have to read our request from br. (buffered reader)
                reqS += (char) br.read();

            System.out.println(reqS);

            HttpRequest req = new HttpRequest(reqS);

            /*
            now we pass the HTTP request to the HTTP response class.
            to get a response.
             */
            HttpResponse res = new HttpResponse(req);

            pw.write(res.response.toCharArray());
            pw.close();
            br.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

