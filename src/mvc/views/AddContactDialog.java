/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;
//import javax.swing.JOptionPane;
// vo object class
import mvc.models.Person;
// for GUI
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mvc.controller.AddressBookController;

/**
 *
 * @author Admin
 */
public class AddContactDialog implements ActionListener{
    private JFrame frame;
    private DetailViewPanel detailsPanel;
    private JButton submitButton;
    private JButton btn_cancel;
    private JPanel panel_btn;
    private Person  person;
    private AddressBookController controller;

    
    public AddContactDialog(){
        frame = new JFrame("New Entries");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setVisible(true);
        
        detailsPanel = new DetailViewPanel();
        frame.getContentPane().add(detailsPanel,BorderLayout.CENTER);
        
        panel_btn= new JPanel();
        panel_btn.setLayout(new GridLayout(1, 2));
        
        submitButton = new JButton("Submit");
        panel_btn.add(submitButton);
        
        btn_cancel = new JButton("Cancel");
        panel_btn.add(btn_cancel);
        
        frame.getContentPane().add(panel_btn,BorderLayout.SOUTH);
        
        submitButton.addActionListener(this);
        btn_cancel.addActionListener(this);
        
        
        
    }
      /*  submitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
                String name = detailsPanel.getNameField().getText();
                String mobile = detailsPanel.getMobileField().getText();
                String email = detailsPanel.geteMailField().getText();
                if (name==null||name.equals(""))
                    JOptionPane.showMessageDialog(frame, "Name Reqired");
                else if(mobile==null||mobile.equals(""))
                    JOptionPane.showMessageDialog(frame, "Mobile No.  Reqired");
                 else
                {
               //  Person person = new Person();   
                  person.setData(name,mobile,email);
                 //person = person;
                }
                System.out.println("yet to create -- have to go to controller "+person.getName());
               //  System.out.println(person.getName());
              //  frame.setVisible(false);
                
                //sendPerson();
                
            }
           }); 
        
   
        btn_cancel = new JButton("Cancel");
        panel_btn.add(btn_cancel);
        
        frame.getContentPane().add(panel_btn,BorderLayout.SOUTH);
    }*/
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submitButton){
  /*      String name = detailsPanel.getNameField().getText();     
        System.out.println(name);
 */
        //validate();
             String name = detailsPanel.getNameField().getText();
             String mobile = detailsPanel.getMobileField().getText();
             String email = detailsPanel.geteMailField().getText();
             if (name==null||name.equals("")||(mobile==null||mobile.equals("")))
                    JOptionPane.showMessageDialog(frame, "Fields Marked as * are Mandatory");
             else 
                    person = new Person();
                    person.setData(name,mobile,email);
        
      //  System.out.println("after validate()");
        System.out.println(person.getName());
        controller = new AddressBookController(person, "Add");
        //controller.addUser(person);
        }
        if (ae.getSource()==btn_cancel)
        {
            System.out.println("pressed cancel)");
        }
    }
        public void validate(){
        boolean valid = false;
           String name = detailsPanel.getNameField().getText();
                String mobile = detailsPanel.getMobileField().getText();
                String email = detailsPanel.geteMailField().getText();
                if (name==null||name.equals("")||(mobile==null||mobile.equals("")))
                    JOptionPane.showMessageDialog(frame, "Fields Marked as * are Mandatory");
                else 
                    person.setData(name,mobile,email);

                    valid = true;
                //return valid;
                /*else if(mobile==null||mobile.equals(""))
                    JOptionPane.showMessageDialog(frame, "Mobile No.  Reqired");*/
                 
        }
/*  public Person sendPerson(){} */ 


   
}

