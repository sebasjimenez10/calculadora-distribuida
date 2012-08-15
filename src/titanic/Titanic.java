/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanic;

import titanic.gui.MainTitanicWindow;
/**
 *
 * @author Menes
 */
public class Titanic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainTitanicWindow mtw = new MainTitanicWindow();
        EventHandler e = new EventHandler(mtw);
        mtw.setVisible(true);
    }
}
