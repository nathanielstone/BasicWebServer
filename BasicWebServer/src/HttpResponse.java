import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * Created by NathanStone on 11/28/15.
 */
public class HttpResponse {

    Date date = new Date();

        HttpRequest req;
        String response;
        String root = "MacintoshHD/Users/NathanStone/Desktop/Root Folder";

    public HttpResponse(HttpRequest request) {
        req = request;
        File f = new File(root + req.filename);

        try {

          /* String responseHeader =
                    "HTTP/1.0 200 Document follows\n" +Ω
                    "MIME-Version: 1.0\n" +
                    "Server: CERN/3.0\n" +
                    "Date: Sunday, 10-Nov-96 06:54:46 GMT\n" +
                    "Content-Type: text/html\n" +
                    "Content-Length: 4531\n" +
                    "Last-Modified: Wednesday, 16-Oct-96 10:14:01 GMT";
            */
            response = "HTTP/1.1 200";

            response += " Server: Our JAVA BASIC SERVER/1.0\r\n";

            response += " Content-Type: text/html \r\n";

            response += " Connection: close \r\n";

            response += " Content - Length: " + f.length() + "\r\n";

            response += "\r\n";

            response += date.toString();

            response += root;

            FileInputStream fis = new FileInputStream(f);


            int s;


            while ((s = fis.read()) != -1) {


                response += (char) s;
            }
            fis.close();

        }catch (FileNotFoundException e){

            response = response.replace("200", "404");


        }catch (Exception e){

            response = response.replace("200", "500");

        }

        }

}
