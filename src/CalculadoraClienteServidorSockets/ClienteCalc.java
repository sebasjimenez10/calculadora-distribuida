/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraClienteServidorSockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Menes
 */
public class ClienteCalc {

    public static void main(String args[]) {
        int port = 1234;
        try {
            Socket skt = new Socket("localhost", port);
            PrintWriter out = new PrintWriter( skt.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            
            System.out.print("Received message: " + in.readLine());
            System.out.println("Sending name...");
            
            out.println("4 / 2");
            
            System.out.println("The result is: " + in.readLine());
            in.close();     
            out.close();
            skt.close();
            
        } catch (Exception e) {
            System.out.println("Whoops! It didn't work!");
            System.out.println(e.getMessage());
        }
    }
}