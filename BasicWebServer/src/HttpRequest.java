/**
 * Created by NathanStone on 11/28/15.
 */
public class HttpRequest {
    String filename;

    public HttpRequest(String request) {
        String lines[] = request.split("\n");
        lines = lines[0].split(" ");
        filename = lines[1];
    }
}
