/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import mvc.controller.AddressBookController;
import mvc.models.Person;
import mvc.views.AddContactDialog;
import mvc.views.AddressBookMainGUI;
import mvc.util.DbConnect;
/**
 *
 * @author admin
 */
public class ContactImpl implements ContactIntf{

     @Override
     public List loadUsers() {
       List<Person> lp = null;
       Connection con =DbConnect.getInstance().getConnect();
        try {
            Statement st = con.createStatement();
            String qry = "select * from addbook order by name asc";
            ResultSet rs = st.executeQuery(qry);
            lp=new ArrayList<Person>();
            while(rs.next()){
                //Person[] ob = {rs.getString("name").toString()};
                //dtm.addRow(ob);
                Person p =new Person();
                p.setData(rs.getString("name").toString(), rs.getString("mob").toString(), rs.getString("email").toString());
                lp.add(p);
            }
            con.close();
        }catch (SQLException ex) {
            //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }

    @Override
    public void loadUser(AddressBookMainGUI mPage) {
       Person user = getUser(mPage);
       mPage.getjTextField1().setText(user.getName());
       mPage.getjTextField2().setText(user.getMob());
       mPage.getjTextField3().setText(user.getEmail());
    }

    @Override
    public Person getUser(AddressBookMainGUI mPage) {
        Person u = new Person();
        int idx = mPage.getjTable1().getSelectedRow();
        if(idx==-1){
            JOptionPane.showMessageDialog(mPage, "No name is selected");
        }
        else{
        TableModel tbl = mPage.getjTable1().getModel();
        String name = tbl.getValueAt(idx, 0).toString();
        
        try {
            Connection con =DbConnect.getInstance().getConnect();
            Statement st = con.createStatement();
            String qry = "select * from addbook where name='"+name+"'";
            ResultSet rs = st.executeQuery(qry);
            while(rs.next()){

              u.setName(rs.getString("name"));
              u.setMob(rs.getString("mob"));
              u.setEmail(rs.getString("email"));

            }
        } catch (Exception e) {
        }
        }
        return u;
    }

    @Override
    public void populateMain(Person user, AddressBookMainGUI mPage) {
       mPage.getjTextField1().setText(user.getName());
        mPage.getjTextField2().setText(user.getMob());
        mPage.getjTextField3().setText(user.getEmail());
    }

    @Override
    public void addUser(Person user,AddressBookMainGUI mPage) {
       try {
           Connection con =DbConnect.getInstance().getConnect();
           Statement st = con.createStatement();
           String qry = "insert into addbook values ('"+user.getName()+"','"+user.getMob()+"','"+user.getEmail()+"')";
           st.executeUpdate(qry);
           loadUsers(mPage);
                    
       } catch (Exception e) {
           System.out.println("Add Error :"+ e);
       }
    }

    @Override
    public void populateEdit(AddressBookMainGUI mPage) {
         
       Person u = getUser(mPage);
       try{
       if(u.getName().isEmpty()||u.getMob().isEmpty()||u.getEmail().isEmpty()){}
       else{
       EditForm editForm = new EditForm(mPage,u);
       editForm.getjTextField1().setText(u.getName());
       editForm.getjTextField2().setText(u.getMob());
       editForm.getjTextField3().setText(u.getEmail());
       editForm.setVisible(true);
       }
       }catch(NullPointerException ne){}
    }

    @Override
    public void editUser(Person user,AddressBookMainGUI mPage, String uname) {
        try {
          Connection con =DbConnect.getInstance().getConnect();
           Statement st = con.createStatement();
           String qry="update addbook set name='"+user.getName()+"',mob='"+user.getMob()+"',email='"+user.getEmail()+"' where name='"+uname+"'";
           int flag = st.executeUpdate(qry);
           loadUsers(mPage);
           populateMain(user, mPage);
          
                    
       } catch (Exception e) {
           System.out.println("Update Error :"+ e);
       }
    }

    @Override
    public void deleteUser(AddressBookMainGUI mPage) {
       Person u = getUser(mPage);
        try{
             if(u.getName().isEmpty()||u.getMob().isEmpty()||u.getEmail().isEmpty()){}
            else{
            String uname = u.getName();
            int ch = JOptionPane.showConfirmDialog(mPage, "Do u really want to delete '"+uname+"'?");
            if(ch==0){
            try {
               Connection con =DbConnect.getInstance().getConnect();
               Statement st = con.createStatement();
               String qry="delete from addbook where name='"+uname+"'";
               int flag = st.executeUpdate(qry);
               loadUsers(mPage);
            } catch (Exception e) {
            System.out.println("Delete Error :"+ e);
            }
           }
          }
       }catch(NullPointerException ne){}
    }

}
