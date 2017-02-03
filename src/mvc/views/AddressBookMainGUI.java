/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;

//vo object
import mvc.models.Person;

import mvc.controller.AddressBookController;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class AddressBookMainGUI {
    
    private JFrame frame;
    private NameListPanel contactList;
    private DetailViewPanel detailsPanel;
    private JButton btn_add;
    private JButton btn_edit;
    private JButton btn_delete;
    private JPanel panel_btn;
    
    
    
     private AddContactDialog add;
     
     
   //private
        //    Person person = new Person();
        
    public AddressBookMainGUI(String text){
        frame = new JFrame("Address Book");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
        contactList=new NameListPanel();
        frame.getContentPane().add(contactList,BorderLayout.WEST);
        
        detailsPanel=new DetailViewPanel();
        frame.getContentPane().add(detailsPanel,BorderLayout.CENTER);
        
        panel_btn= new JPanel();
        panel_btn.setLayout(new GridLayout(1, 3));
        
       /* JButton addButton = new JButton("Submit");
        addButton.setSize(10, 60);
        panel_btn.add(addButton);
        //addButton.setVisible(true);
        addButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                System.out.println("yet to create");
            }
            
        });*/
        
        btn_add = new JButton("Add");
        panel_btn.add(btn_add);
        
        btn_edit = new JButton("Edit");
        panel_btn.add(btn_edit);
        
        btn_delete = new JButton("Delete");
        panel_btn.add(btn_delete);
        
        frame.getContentPane().add(panel_btn,BorderLayout.SOUTH);
    }
    
    public  Person addPerson(Person person)
    {
        return person;
    }
            
    
    //btn_add.add
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
