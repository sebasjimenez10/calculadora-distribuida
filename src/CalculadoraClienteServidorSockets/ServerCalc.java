/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraClienteServidorSockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Menes
 */
public class ServerCalc {

    public static void main(String args[]) {
        int port = 1234;
        try {
            ServerSocket srvr = new ServerSocket(1234);
            System.out.println("Server created, waiting for connections...");
            while (true) {
                Socket skt = srvr.accept();
                System.out.print("Server has connected!\n");
                PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
                out.println("Please right your math operation. (eg. 1 / 3). Remeber the white spaces.");
                
                String str = in.readLine();
                String content[] = str.split(" ");
                
                float a = Float.parseFloat(content[0]);
                float b = Float.parseFloat(content[2]);
                if( content[1].equals("+") ){
                    str = (a + b) + "";
                }else if( content[1].equals("-") ){
                    str = (a - b) + "";
                }else if( content[1].equals("*") ){
                    str = (a * b) + "";
                }else if( content[1].equals("/") ){
                    str = (a / b) + "";
                }                
                //Result
                out.println(str);
                in.close();
                out.close();
                skt.close();
            }
        } catch (Exception e) {
            System.out.print("Whoops! It didn't work!\n");
            System.out.println(e.getMessage());
        }
    }
}
