/**
 * Created by NathanStone on 11/28/15.
 */public class HttpRequest {
    String filename;

    /*
    Creates a constructor that accepts the string mentioned earlier.
     */

    public HttpRequest(String request) {
        String lines[] = request.split("\n");
        lines = lines[0].split(" ");
        filename = lines[1];
    }
}
