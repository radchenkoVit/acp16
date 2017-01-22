package week1_aco15.secondTry.contactApp.controllers;

import week1_aco15.secondTry.contactApp.enums.ContactField;
import week1_aco15.secondTry.contactApp.enums.MobileOperator;
import week1_aco15.secondTry.contactApp.model.Contact;
import week1_aco15.secondTry.contactApp.utils.Finder;
import week1_aco15.secondTry.contactApp.view.IContactListView;

import java.util.List;

//TODO: where should be validation for setting fields for contact, guess in this case as a pricate methods for ContactList controller
//As a variant create snth like Contact controller - to have all validation for class fields
public class ContactListControlImpl implements IContactListControl {
    private List<Contact> contactList;
    private IContactListView listView;

    public ContactListControlImpl(List<Contact> contactList, IContactListView listView){
        this.contactList = contactList;
        this.listView = listView;
    }

    public boolean addContact(Contact contact) {
        if (isUnique(contact.getFirstName())) {
            return contactList.add(contact);
        }

        return false;
    }

    public Contact removeLast() {
        return contactList.remove(contactList.size() - 1);
    }

    public Contact findContact(int fieldIndex, String value) {
        Finder finder = new Finder(contactList);
        Contact contact = finder.find(ContactField.getField(fieldIndex), value);
        return contact;
    }


    public boolean removeContact(int fieldIndex, String value) {
        Contact contact = findContact(fieldIndex, value);
        return contactList.remove(contact);
    }

    public boolean removeContact(Contact contact) {
        return contactList.remove(contact);
    }

    //TODO:
    public boolean updateContactInfo(int fieldIndex, String value) {
        Finder finder = new Finder(contactList);
        Contact contact = finder.find(ContactField.getField(fieldIndex), value);

        if (contact != null) {
            //TODO: as variant move to separate class
            return updateContact(contact, ContactField.getField(fieldIndex), value);
        }

        return false;
    }

    public void showAllContacts() {
        listView.showAllContacts(contactList);
    }

    public void showFirstFiveContacts() {
        listView.showFirstFiveContacts(contactList);
    }

    public void showLastFiveContacts() {
        listView.showLastFiveContacts(contactList);
    }

    public void showContacts(MobileOperator operator) {
        listView.showContacts(operator, contactList);
    }

    public void showLifeContacts() {
        listView.showContacts(MobileOperator.Life, contactList);
    }

    public void showKievStarContacts() {
        listView.showContacts(MobileOperator.KyivStar, contactList);
    }

    public Contact createContact() {
        return null;
    }

    public int getContactToFind() {
        return 0;
    }

    public int getContactToRemove() {
        return 0;
    }

    private boolean updateContact(Contact contact, ContactField field, String value){
        if (field == ContactField.FirstName && containsOnlyCharacter(value)){
            contact.setFirstName(value); return true;
        } else if (field == ContactField.LastName && containsOnlyCharacter(value)){
            contact.setLastName(value); return true;
        } else if (field == ContactField.PhoneNumber && containsOnlyDigit(value)){
            contact.setPhoneNumber(value); return true;
        }

        return false;
    }



    private boolean containsOnlyCharacter(String validateString){
        String regex =  "^[ A-z]+$";//copyPast from inet
        return validateString.matches(regex);

    }

    private boolean containsOnlyDigit(String validateString){
        String regex =  "\\d{10}";//copyPast from inet
        return validateString.matches(regex);

    }

    private boolean isUnique(String byFirstName){
        for (Contact contact: contactList){
            if (contact.getFirstName().equalsIgnoreCase(byFirstName))
                return false;
        }

        return true;
    }
}
