package co.edu.escuelaing.arsw.tallernet.sockets;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class HTTPServer extends Thread{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        // Server On
        int idSession = 0;
        Socket clientSocket;
        ArrayList<Socket> openSockets = new ArrayList<>();
        while (true) {
            System.out.println("Listo para recibir...");
            clientSocket = serverSocket.accept();
            ((ThreadWeb) new ThreadWeb(clientSocket, idSession)).start();
            openSockets.add(clientSocket);
            System.out.println(idSession);
            idSession++;

        }
       // clientSocket.close();
       // serverSocket.close();
    }

}
