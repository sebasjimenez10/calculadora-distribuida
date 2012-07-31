/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraClienteServidorSockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johanna
 */
public class ClienteUI {
    
    public String showOpciones() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Menu principal, escoja una opcion.\n"
                + " 1. Hacer operacion\n"
                + " 2. Salir");
        String opcion = input.readLine();
        String operacion = "";
        if (opcion.equalsIgnoreCase("1")) {
            System.out.println("Ingrese la operacion. (ej. 10 * 2)");
            operacion = input.readLine();
        } else if (opcion.equalsIgnoreCase("2")) {
            operacion = "exit";
        }
        return operacion;
    }
    
   
    
    public static void main(String[] args) {
        
        int puerto = Integer.parseInt(args[0]);
        String host = args[1];
        
        ClienteUI c = new ClienteUI();
        ClienteConnection x = new ClienteConnection();
        try {
            String operacion = c.showOpciones();
            x.conexion(puerto, host, operacion);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
