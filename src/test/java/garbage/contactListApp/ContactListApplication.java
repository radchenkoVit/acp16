package garbage.contactListApp;

import garbage.contactListApp.enums.FindBy;
import garbage.contactListApp.exceptions.NotFoundException;
import garbage.contactListApp.model.Contact;
import garbage.contactListApp.utils.Finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static garbage.contactListApp.InputString.*;

public class ContactListApplication implements ApplicationInterface {

    private List<Contact> contactList;

    public ContactListApplication(){
        contactList = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        Finder finder = new Finder(contactList);
        if (finder.isUnique(contact.getFirstName())) {
            return contactList.add(contact);
        }

        return false;
    }

    public void removeLast(){
        contactList.remove(contactList.size() - 1);
    }

    public void updateContact(Contact contact) {

    }

    public Contact findContact(FindBy findBy, String compareValue) throws NotFoundException {
        Finder finder = new Finder(contactList);
        return finder.find(findBy, compareValue);
    }

    public void updateContact() throws IOException, NotFoundException {
        Contact contactToUpdated;
        try {
            contactToUpdated = findContact();
        } catch (NotFoundException e){
            System.out.println(e.getMessage());
            return;
        }

        //displayMenu(UPDATE_MESSAGE);
        int choice = enterInt();
        FindBy chosenOption = FindBy.getByIndex(choice);

        System.out.println(String.format("Enter: %s", chosenOption.getName()));
        String findByString = enterString();

        Finder finder = new Finder(contactList);
    }


    //TODO: where find logic should be implemented: display menu, etc
    public Contact findContact() throws IOException, NotFoundException {;
        int choice = enterInt();
        FindBy chosenOption = FindBy.getByIndex(choice);

        System.out.println(String.format("Enter: %s", chosenOption.getName()));
        String findByString = enterString();

        Finder finder = new Finder(contactList);
        return finder.find(chosenOption, findByString);
    }

    public boolean removeContact(Contact contact){
        boolean isContain = contactList.contains(contact);
        if (!isContain){
            System.out.println("No contacts found");
            return false;
        } else {
            return contactList.remove(contact);
        }
    }




}
