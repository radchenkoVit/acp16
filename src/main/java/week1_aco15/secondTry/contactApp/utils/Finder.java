package week1_aco15.secondTry.contactApp.utils;

import week1_aco15.secondTry.contactApp.enums.ContactField;
import week1_aco15.secondTry.contactApp.model.Contact;

import java.util.List;

public class Finder {
    private List<Contact> contactList;

    public Finder(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Contact find(ContactField contactField, String value) {
        if (contactField == ContactField.LastName){
            for (Contact contact: contactList){
                if (contact.getLastName().equalsIgnoreCase(value));
                return contact;
            }
        } else if (contactField == ContactField.FirstName){
            for (Contact contact: contactList){
                if (contact.getFirstName().equalsIgnoreCase(value));
                return contact;
            }
        } else if (contactField == ContactField.PhoneNumber){
            for (Contact contact: contactList){
                if (contact.getPhoneNumber().equalsIgnoreCase(value));
                return contact;
            }
        }

        //TODO: don't like
        return null;
    }
}
