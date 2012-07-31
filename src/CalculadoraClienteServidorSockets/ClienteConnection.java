/*
 * Topicos Esp. en Telematica
 * Reto # 1.
 * Integrantes: Johanna Lozano, David Sttivend, Sebastian Jimenez.
 * 
 * Descripcion: Calculadora Distribuida. ClienteCalc class
 * 
 */
package CalculadoraClienteServidorSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author The Lentidudes
 */
public class ClienteConnection {

    public void conexion(int port, String host, String operacion) throws IOException {

        //Creates the socket with the host and port variables
        Socket skt = new Socket(host, port);

        //Creates the socket streams
        PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        
        //Send back users input
        
        if (operacion.equalsIgnoreCase("exit")) {
            System.out.println("---Connection closed---");
            out.println(operacion);
            skt.close();
        } else {
            out.println(operacion);

            //Getting the operation result
            System.out.println("The result is: " + in.readLine());

            //Close the streams and the socket
            in.close();
            out.close();
            skt.close();
        }
        
    }
}