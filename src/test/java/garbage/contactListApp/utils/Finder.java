package garbage.contactListApp.utils;

import garbage.contactListApp.enums.FindBy;
import garbage.contactListApp.exceptions.NotFoundException;
import garbage.contactListApp.model.Contact;

import java.util.List;

import static garbage.contactListApp.enums.FindBy.LastName;

public class Finder {
    private List<Contact> contactList;

    public Finder(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Contact find(FindBy findBy, String compareValue) throws NotFoundException {
        if (findBy == LastName){
            for (Contact contact: contactList){
                if (contact.getLastName().equalsIgnoreCase(compareValue));
                return contact;
            }
        } else if (findBy == FindBy.Name){
            for (Contact contact: contactList){
                if (contact.getFirstName().equalsIgnoreCase(compareValue));
                return contact;
            }
        } else if (findBy == FindBy.PhoneNumber){
            for (Contact contact: contactList){
                if (contact.getPhoneNumber().equalsIgnoreCase(compareValue));
                return contact;
            }
        } else {
            for (Contact contact: contactList){
                if (contact.getNote().equalsIgnoreCase(compareValue));
                return contact;
            }
        }

        throw new NotFoundException("Contact was not found");
    }

    public boolean isUnique(String name){
        for (Contact contact: contactList){
            if (contact.getFirstName().equalsIgnoreCase(name))
                return false;
        }

        return true;
    }
}
