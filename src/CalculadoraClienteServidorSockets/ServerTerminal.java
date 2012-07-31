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
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Lentidudes
 */
public class ServerTerminal extends Thread {
    
    //Server que establece el canal para la conexion
    ServerSocket sktsrvr;

    //Constructor
    public ServerTerminal(ServerSocket sktsrvr) {
        this.sktsrvr = sktsrvr;
    }
    
    //Hilo que se encarga de escuchar hasta que se digite "exit" en la terminal del server
    @Override
    public void run(){
        while(true){
            try {
                //Input
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String line = in.readLine();
                
                //Check
                if( line.equalsIgnoreCase("exit") ){
                    sktsrvr.close();
                    break;
                }else{
                    System.out.println("Opcion no valida. Intente con \"exit\"");
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerTerminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
