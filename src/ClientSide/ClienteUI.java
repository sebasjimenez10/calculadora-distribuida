/*
 * Topicos Esp. en Telematica
 * Reto # 1.
 * Integrantes: Johanna Lozano, David Sttivend, Sebastian Jimenez.
 * 
 * Descripcion: Calculadora Distribuida.
 * 
 */

package ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Lentidudes
 */
public class ClienteUI {
    
    public String showOpciones() throws IOException {
        //User input
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        //Shows principal menu
        System.out.println("Menu principal. Escoja una opcion.\n"
                + " 1. Hacer operacion\n"
                + " 2. Salir");

        //Gets the input and cases it
        String opcion = input.readLine();
        String operacion = null;
        if (opcion.equalsIgnoreCase("1")) {
            System.out.println("Ingrese la operacion. (ej. 10 * 2)");
            operacion = input.readLine();
        } else if (opcion.equalsIgnoreCase("2")) {
            operacion = "exit";
        }
        return operacion;
    }   
    
    public static void main(String[] args) {
        try {
            //Input
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            //Initialize the parameters
            System.out.println("Ingrese el puerto por el cual esta corriendo el server.");
            int puerto = Integer.parseInt( input.readLine() );
            System.out.println("Ingrese el host. ej \"localhost\"");
            String host = input.readLine();

            //Gets the operation and stabilsh connection
            ClienteUI c = new ClienteUI();
            ClienteConnection x = new ClienteConnection();
        
            String operacion = c.showOpciones();
            x.conexion(puerto, host, operacion);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
