/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import javax.swing.SwingUtilities;
import mvc.controller.AddressBookController;
import mvc.models.Person;
import mvc.views.AddressBookMainGUI;

/**
 *
 * @author Admin
 */
public class Startingpoing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
               // User model=new User();
               // MainGUI view=new MainGUI("-");
                AddressBookController controller=new AddressBookController();
                controller.control();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
