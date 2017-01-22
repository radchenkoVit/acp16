package garbage.contactListApp;

import garbage.contactListApp.model.Contact;

import java.io.IOException;

import static garbage.contactListApp.InputString.reader;

public class ContactBuilder {
    private Contact contact = new Contact();

    public ContactBuilder(){}

    public ContactBuilder addFirstName(String firstName){
        if (firstName != null && !firstName.isEmpty()) {
            contact.setFirstName(firstName);
        }

        return this;
    }

    public ContactBuilder addLastName(String lastName){
        if (lastName != null && !lastName.isEmpty()) {
            contact.setLastName(lastName);
        }

        return this;
    }

    public ContactBuilder addPhoneNumber(String phoneNumber){
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            contact.setPhoneNumber(phoneNumber);
        }

        return this;
    }

    public ContactBuilder addNote(String note){
        if (note != null && !note.isEmpty()) {
            contact.setNote(note);
        }

        return this;
    }

    public Contact getContact(){
        return contact;
    }

    //TODO: don't like
    public static Contact createContract() throws IOException {
        ContactBuilder contactBuilder = new ContactBuilder();
        System.out.println("Enter, First Name: ");
        contactBuilder.addFirstName(reader.readLine());

        System.out.println("Enter, Last Name: ");
        contactBuilder.addLastName(reader.readLine());

        System.out.println("Enter, Phone Number: ");
        contactBuilder.addPhoneNumber(reader.readLine());

        System.out.println("Enter, Note: ");
        contactBuilder.addNote(reader.readLine());

        return contactBuilder.getContact();
    }
}
