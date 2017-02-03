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
public class EditContactPanel {
    private JFrame frame;
    private DetailViewPanel detailsPanel;
    private JButton btn_edit;
    private JButton btn_cancel;
    private JPanel panel_btn;

    
    public EditContactPanel(String text){
        frame = new JFrame("View");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setVisible(true);
        
        detailsPanel = new DetailViewPanel();
        frame.getContentPane().add(detailsPanel,BorderLayout.CENTER);
        
        panel_btn= new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        
        btn_edit = new JButton("Edit");
        panel_btn.add(btn_edit);
        
        btn_cancel = new JButton("Cancel");
        panel_btn.add(btn_cancel);
        
        frame.getContentPane().add(panel_btn,BorderLayout.SOUTH);
    }
    

}
