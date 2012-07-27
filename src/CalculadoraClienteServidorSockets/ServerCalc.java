/*
 * Topicos Esp. en Telematica
 * Reto # 1.
 * Integrantes: Johanna Lozano, David Sttivend, Sebastian Jimenez.
 * 
 * Descripcion: Calculadora Distribuida. ServerCalc class
 * 
 */
package CalculadoraClienteServidorSockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author The Lentidudes
 */
public class ServerCalc {
    
    /**
     * Only one parameter, port.
     * @param args 
     */
    
    public static void main(String args[]) {
        //Port to stablish connection
        int port = 1234;
        try {
            //Creates a ServerSocket in the port "port".
            ServerSocket srvr = new ServerSocket( port );
            System.out.println("Server created, waiting for connections...");
            
            while (true) {
                //Socket waits for some connection
                Socket skt = srvr.accept();
                System.out.println("Server connected to: " + skt.getInetAddress().getHostAddress().toString());
                
                //Creates the streams
                PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
                BufferedReader in = new BufferedReader( new InputStreamReader( skt.getInputStream() ) );
                
                //Sends message
                out.println("Please write your math operation. (eg. 10 / 3). Remeber the white spaces.");
                
                //Gets the message sent from de client and process it
                String str = in.readLine();
                if( str.equalsIgnoreCase("exit") ){
                    System.out.println( "---Client disconnected---" );
                }else{
                    String content[] = str.split(" ");
                    float a = Float.parseFloat(content[0]);
                    float b = Float.parseFloat(content[2]);

                    //Math
                    if (content[1].equals("+")) {
                        str = (a + b) + "";
                    } else if (content[1].equals("-")) {
                        str = (a - b) + "";
                    } else if (content[1].equals("*")) {
                        str = (a * b) + "";
                    } else if (content[1].equals("/")) {
                        str = (a / b) + "";
                    }
                    //Send back result
                    out.println(str);

                    //Close the streams and the socket
                    in.close();
                    out.close();
                    skt.close();
                }
            }
        } catch (Exception e) {
            //Get error message
            System.out.println("Error: " + e.getMessage());
        }
    }
}