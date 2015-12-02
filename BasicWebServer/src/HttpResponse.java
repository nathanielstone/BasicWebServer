import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by NathanStone on 11/28/15.
 */
public class HttpResponse {
    Date date = new Date();
    String response;

    public HttpResponse(HttpRequest request) {
        File f = new File(request.filename);
        try {

            response = "HTTP/1.1 200";
            response += " Server: Our JAVA BASIC SERVER/1.0\r\n";
            response += " Content-Type: text/html \r\n";
            response += " Connection: close \r\n";
            response += " Content - Length: " + f.length() + "\r\n";
            response += "\r\n";
            response += date.toString();
            response += "\r\n";
            response += "";
            response += "HELLO DENEKE";

            FileInputStream fis = new FileInputStream(f);
            int s;
            while ((s = fis.read()) != -1) {
                response += (char) s;
            }
            fis.close();
        } catch (FileNotFoundException e) {
            response = response.replace("200", "404");
        } catch (Exception e) {
            response = response.replace("200", "500");
        }
    }

}