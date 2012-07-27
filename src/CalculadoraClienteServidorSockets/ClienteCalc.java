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
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author The Lentidudes
 */
public class ClienteCalc {

    public static void main(String args[]) {
        //Port and host to stablish connection
        String host = "localhost";
        int port = 1234;
        try {
            //Creates the socket with the host and port variables
            Socket skt = new Socket(host, port);

            //Creates the socket streams
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

            //Getting de received message
            System.out.println("Received message: " + in.readLine());
            System.out.println("Type operation or exit to disconnect from server");

            //Send back users input
            String response = userIn.readLine();
            if (response.equalsIgnoreCase("exit")) {
                System.out.println("---Connection closed---");
                out.println(response);
                skt.close();
            } else {
                out.println(response);

                //Getting the operation result
                System.out.println("The result is: " + in.readLine());

                //Close the streams and the socket
                in.close();
                out.close();
                skt.close();
            }
        } catch (Exception e) {
            //Get error message
            System.out.println("Message: " + e.getMessage());
        }
    }
}