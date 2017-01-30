/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class MainGUI {
    
    private JFrame frame;
    private ContactList contactList;
    private DetailsPanel detailsPanel;
    private JButton btn_add;
    private JButton btn_edit;
    private JButton btn_delete;
    private JPanel panel_btn;
    
    public MainGUI(String text){
        frame = new JFrame("Address Book");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
        contactList=new ContactList();
        frame.getContentPane().add(contactList,BorderLayout.WEST);
        
        detailsPanel=new DetailsPanel();
        frame.getContentPane().add(detailsPanel,BorderLayout.CENTER);
        
        panel_btn= new JPanel();
        panel_btn.setLayout(new GridLayout(1, 3));
        
        btn_add = new JButton("Add");
        panel_btn.add(btn_add);
        
        btn_edit = new JButton("Edit");
        panel_btn.add(btn_edit);
        
        btn_delete = new JButton("Delete");
        panel_btn.add(btn_delete);
        
        frame.getContentPane().add(panel_btn,BorderLayout.SOUTH);
    }
    
    public JButton getAdd(){
        return btn_add;
    }
    
    public JButton getEdit(){
        return btn_edit;
    }
    
    public JButton getDelete(){
        return btn_delete;
    }
    public void setText(String text){
       // label.setText(text);
    }
}
