/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class AddContact {
    private JFrame frame;
    private DetailsPanel detailsPanel;
    private JButton btn_add;
    private JButton btn_cancel;
    private JPanel panel_btn;

    
    public AddContact(String text){
        frame = new JFrame("View");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setVisible(true);
        
        detailsPanel = new DetailsPanel();
        frame.getContentPane().add(detailsPanel,BorderLayout.CENTER);
        
        panel_btn= new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        
        btn_add = new JButton("Add");
        panel_btn.add(btn_add);
        
        btn_cancel = new JButton("Cancel");
        panel_btn.add(btn_cancel);
        
        frame.getContentPane().add(panel_btn,BorderLayout.SOUTH);
    }
    

}
