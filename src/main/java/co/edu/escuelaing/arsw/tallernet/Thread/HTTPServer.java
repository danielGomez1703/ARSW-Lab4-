package co.edu.escuelaing.arsw.tallernet.Thread;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer extends Thread{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        int port = getPort();
        try {
            serverSocket = new ServerSocket(port   );
        } catch (IOException e) {
            System.err.println("Could not listen on port "+ port );
            System.exit(1);
        }
        // Server On
        
        int idSession = 0;
        Socket clientSocket;
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            System.out.println("Listo para recibir...");
            clientSocket = serverSocket.accept();
            pool.execute( new ThreadWeb(clientSocket, idSession));
            System.out.println(idSession);
            idSession++;
        }
       // clientSocket.close();
       
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}


