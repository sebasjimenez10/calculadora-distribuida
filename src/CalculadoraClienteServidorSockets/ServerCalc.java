/*
 * Topicos Esp. en Telematica
 * Reto # 1.
 * Integrantes: Johanna Lozano, David Sttivend, Sebastian Jimenez.
 * 
 * Descripcion: Calculadora Distribuida. ServerCalc class
 * 
 */
package CalculadoraClienteServidorSockets;

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
            ServerSocket srvr = new ServerSocket(port);
            
            ServerTerminal st = new ServerTerminal(srvr);
            st.start();
            System.out.println("Server created, waiting for connections...");
            while (true) {
                //Socket waits for some connection
                Socket skt = srvr.accept();
                System.out.println("Server connected to: " + skt.getInetAddress().getHostAddress().toString());

                //Starts calc thread to attend multiple clients
                Calculadora c = new Calculadora(skt);
                c.start();
            }
        } catch (Exception e) {
            //Get error message
            System.out.println("Message: " + e.getMessage());
        }
    }
}
