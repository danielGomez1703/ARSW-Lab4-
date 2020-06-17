/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.tallernet.Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danip
 */
public class ClienteWeb implements Runnable {

    private final Socket clientSocket;
    private final int session;
    private PrintWriter out;
    private BufferedReader in;
/**
 * creador del cliente web el cual procedera a ahcer la solciitud de la url
 * @param clientSocket
 * @param session 
 */
    public ClienteWeb(Socket clientSocket, int session) {
        this.clientSocket = clientSocket;
        this.session = session;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
 * este metodo inicia el proceso del cliente en su creacion
 */
    @Override
    public void run() {
        URL url = null;
        URLConnection con;
        try {
            url = new URL("http://localhost:35000/prueba2.html");
            con = url.openConnection();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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

        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteWeb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteWeb.class.getName()).log(Level.SEVERE, null, ex);     
        }

    }
}


