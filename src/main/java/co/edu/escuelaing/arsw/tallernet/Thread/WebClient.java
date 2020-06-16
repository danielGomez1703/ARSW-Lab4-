package co.edu.escuelaing.arsw.tallernet.Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WebClient extends Thread {

    PrintWriter out;
    BufferedReader in;
    Socket clientSocket;
    int session;
    
    public WebClient(Socket clientSocket,int session) {
        this.clientSocket=clientSocket;
        this.session=session;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run() {
        try {
            boolean flag = true;
            String inputLine, outputLine;
            String[] recursos = {};
            while ((inputLine = in.readLine()) != null) {
                if (flag) {
                    recursos = inputLine.split(" ");
                    flag = false;
                }
                if (!in.ready()) {
                    break;
                }
            }
            EncoderFile encod = new EncoderFile();
            if (recursos[0].contains(".JPG")) {
                String img = encod.EncodeImage2("resources/" + recursos[1].substring(1));
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n" + "</head>"
                        + "<body>"
                        + "My Web Site" + recursos[1]
                        + "<img src=" + "data:image/jpg;base64," + img + ">"
                        + "</body>"
                        + "</html>";

                out.println(outputLine);
                out.close();
                in.close();

            } else if (recursos[1].contains(".html")) {
                String file = encod.EncodeHtml("resources/" + recursos[1].substring(1));
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + file;
                out.println(outputLine);
                out.close();
                in.close();
            } else {
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n" + "</head>"
                        + "<body>"
                        + "My Web Site" + recursos[1]
                        + "</body>"
                        + "</html>";

                out.println(outputLine);
                out.close();
                in.close();
                
            }
        clientSocket.close();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

    }
}
