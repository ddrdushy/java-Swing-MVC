/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import mvc.models.Person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.models.Person;
import mvc.views.AddContactDialog;
import mvc.views.EditContactPanel;
import mvc.views.AddressBookMainGUI;

/**
 *
 * @author Admin
 */
public class AddressBookController {
    
    private Person person;
    private AddressBookMainGUI view;
    private ActionListener actionListener;
    private AddContactDialog add;
    private EditContactPanel edit;
    
    public AddressBookController(){
        view =new AddressBookMainGUI("View");
        //this.model = model;
        
    }   
    public AddressBookController(Person person ,String action){
        Person p=person;
        if(action.equals("Add"))
            addUser(p);
    }
   
    
    public void control(){
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.print(e.getSource());
                if(e.getSource()== view.getAdd())
                {
                    openAdd();
                /*    System.out.println();
                //    person = add.sendPerson();
                     System.out.println("In controller "+person.getName());*/
                }
                else if(e.getSource()== view.getEdit())
                    openEdit();
                else if(e.getSource() == view.getDelete())
                    openDelete();
                
                
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        view.getAdd().addActionListener(actionListener);
        view.getDelete().addActionListener(actionListener);
        view.getEdit().addActionListener(actionListener);
    }
    
    
    private void openAdd(){
        add=new AddContactDialog();
      /*Person person = add.sendPerson();*/
        System.out.println("In controller  openAdd ");
        
    }
    public void addUser(Person person)
    {
        System.out.println(person.getName());
        System.out.println("got person in controller");
    }
    
    private void openEdit(){
        edit=new EditContactPanel("Edit");
    }
        
    private void openDelete(){
        //AddContact add=new AddContact("add");
    }
    private void linkBtnandLabel(){
       // view.setText(Integer.toString(model.getX()));        //model.incX();

    }
    
    private void linkBtnandLabel2(){
      //  model.decX();
       // view.setText(Integer.toString(model.getX()));
    }
}
