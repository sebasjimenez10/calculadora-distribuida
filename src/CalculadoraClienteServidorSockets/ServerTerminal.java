/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author sjimen14
 */
public class ServerTerminal extends Thread {

    ServerSocket sktsrvr;

    public ServerTerminal(ServerSocket sktsrvr) {
        this.sktsrvr = sktsrvr;
    }

    @Override
    public void run(){
        while(true){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String line = in.readLine();
                if( line.equalsIgnoreCase("exit") ){
                    sktsrvr.close();
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerTerminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
