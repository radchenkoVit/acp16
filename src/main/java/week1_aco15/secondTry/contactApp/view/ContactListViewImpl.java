package week1_aco15.secondTry.contactApp.view;

import week1_aco15.secondTry.contactApp.enums.ContactField;
import week1_aco15.secondTry.contactApp.enums.MobileOperator;
import week1_aco15.secondTry.contactApp.model.Contact;
import week1_aco15.secondTry.contactApp.model.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContactListViewImpl implements IContactListView {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String findMessage = "Please, enter a filed number to find contact: ";
    private static String removeMessage = "Please, enter a field number to remove contact: ";
    private static String creationMessage = "Please, enter next data to create contact: ";

    public Contact createContact() throws IOException {
        displayMessage(creationMessage);
        String firstName = reader.readLine();
        String lastName = reader.readLine();
        String phoneNumber = reader.readLine();

        return new Contact(firstName, lastName, phoneNumber);
    }

    public Pair<ContactField, String> getContactToFind() throws IOException {
        displayMessage(findMessage);
        int fieldIndex = Integer.parseInt(reader.readLine());
        ContactField filed = ContactField.getField(fieldIndex);

        String value = reader.readLine();
        return new Pair<ContactField, String>(filed, value);
    }

    public Pair<ContactField, String> getContactToRemove() throws IOException {
        displayMessage(removeMessage);
        int fieldIndex = Integer.parseInt(reader.readLine());
        ContactField filed = ContactField.getField(fieldIndex);

        String value = reader.readLine();
        return new Pair<ContactField, String>(filed, value);
    }

    public void showAllContacts(List<Contact> contactList) {
        for (Contact contact: contactList){
            printContact(contact);
        }
    }

    public void showFirstFiveContacts(List<Contact> contactList) {
        for (int i = 0; i < 5 && i < contactList.size(); i++){
            printContact(contactList.get(i));
        }
    }

    public void showLastFiveContacts(List<Contact> contactList) {
        int startIndex = contactList.size() > 4 ? 5 : contactList.size() - 1;

        for (int i = startIndex; i >= 0; i--){
            printContact(contactList.get(0));
        }
    }

    public void showContacts(MobileOperator operator, List<Contact> contactList) {
        for (Contact contact: contactList){
            if (contact.getMobileOperator() == operator){
                printContact(contact);
            }
        }
    }

    public void showContactFields(List<Contact> contactList) {
        for (ContactField contactField : ContactField.values()){
            System.out.println(String.format("%d. %s", contactField.getIndex(), contactField.getName()));
        }
    }

    private static void printContact(Contact contact){
        System.out.println(contact);
    }

    private void displayMessage(String message){
        System.out.println(message);
        for (ContactField field: ContactField.values()){
            System.out.println(field.getName());
        }
    }

    //private Pair<ContactField, String>
    
}
