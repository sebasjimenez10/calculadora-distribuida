/*
 * Topicos Esp. en Telematica
 * Reto # 1.
 * Integrantes: Johanna Lozano, David Sttivend, Sebastian Jimenez.
 * 
 * Descripcion: Calculadora Distribuida.
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
public class Calculadora extends Thread {

    /**
     * Attributes
     */
    Socket skt;
    PrintWriter out;
    BufferedReader in;

    public Calculadora(Socket skt) throws IOException {
        this.skt = skt;
        out = new PrintWriter(skt.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
    }

    @Override
    public void run() {
        try {
            //Gets the message sent from de client and process it
            String str = in.readLine();
            if (str.equalsIgnoreCase("exit")) {
                System.out.println("---Client disconnected---");
            } else {
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
                System.out.println("Client well attended");
                //Close the streams and the socket
                in.close();
                out.close();
                skt.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
