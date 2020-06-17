package co.edu.escuelaing.arsw.tallernet.Thread;

import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPServer{
        int idSession = 0;
        Socket clientSocket;
        ExecutorService pool ;
        ServerSocket serverSocket ;
        
        public HTTPServer (ServerSocket s){
            pool= Executors.newFixedThreadPool(100);
            serverSocket = s;
        // Server On
        }
        
       public void start (){  
         
           while (true) {
               System.out.println("Listo para recibir...");
               try {      
                   clientSocket = serverSocket.accept();
                   pool.execute( new ClienteWeb(clientSocket, idSession));
                   System.out.println("new session # : "+idSession);
                   idSession++;
               } catch (IOException ex) {
                   Logger.getLogger(HTTPServer.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
       // clientSocket.close();
       
       }
        
    
    
    
}


