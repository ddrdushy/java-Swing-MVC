/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.awt.List;
import mvc.models.Person;
import mvc.views.AddressBookMainGUI;

/**
 *
 * @author admin
 */
public interface ContactIntf {
    public List loadUsers();
    public void loadUser(AddressBookMainGUI mPage);
    public Person getUser(AddressBookMainGUI mPage);
    public void populateMain(Person person,AddressBookMainGUI mPage);
    public void addUser(Person person,AddressBookMainGUI mPage);
    public void populateEdit(AddressBookMainGUI mPage);
    public void editUser(Person person,AddressBookMainGUI mPage,String uname);
    public void deleteUser(AddressBookMainGUI mPage);
}
