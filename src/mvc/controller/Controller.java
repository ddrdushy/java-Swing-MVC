/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.models.User;
import mvc.views.AddContact;
import mvc.views.EditContact;
import mvc.views.MainGUI;

/**
 *
 * @author Admin
 */
public class Controller {
    
    private User model;
    private MainGUI view;
    private ActionListener actionListener;
    private AddContact add;
    private EditContact edit;
    
    public Controller(){
        view =new MainGUI("View");
        //this.model = model;
        
    }
    
    public void control(){
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print(e.getSource());
                if(e.getSource()== view.getAdd())
                    openAdd();
                else if(e.getSource()== view.getEdit())
                    openEdit();
                else if(e.getSource() == view.getDelete())
                    openDelete();
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        view.getAdd().addActionListener(actionListener);
        view.getDelete().addActionListener(actionListener);
        view.getEdit().addActionListener(actionListener);
    }
    
    
    private void openAdd(){
        add=new AddContact("Add");
    }
    
    private void openEdit(){
        edit=new EditContact("Edit");
    }
        
    private void openDelete(){
        //AddContact add=new AddContact("add");
    }
    private void linkBtnandLabel(){
        //model.incX();
       // view.setText(Integer.toString(model.getX()));
    }
    
    private void linkBtnandLabel2(){
      //  model.decX();
       // view.setText(Integer.toString(model.getX()));
    }
}
