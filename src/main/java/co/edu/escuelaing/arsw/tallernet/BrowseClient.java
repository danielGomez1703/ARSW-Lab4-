package co.edu.escuelaing.arsw.tallernet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.*;


public class BrowseClient {
        public static void main(String[] args) throws Exception {
             BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Ingrese URL de la pagina : ");
             String pagina = buffer.readLine();
             
             URL url = new URL(pagina);
             FileWriter salida = null;
             PrintWriter write;
             try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                 salida = new FileWriter("resources/prueba2.html");
                 write = new PrintWriter(salida);
                 String inputLine = null;
                 
                 while ((inputLine = reader.readLine()) != null) {
                     write.println(inputLine);
                 }
                 } catch (IOException x) {
                    System.err.println(x);
                 }
        }

}