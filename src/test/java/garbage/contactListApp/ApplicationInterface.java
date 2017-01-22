package garbage.contactListApp;

import garbage.contactListApp.enums.FindBy;
import garbage.contactListApp.exceptions.NotFoundException;
import garbage.contactListApp.model.Contact;

public interface ApplicationInterface {

    boolean addContact(Contact contact);

    void removeLast();

    void updateContact(Contact contact) throws NotFoundException;

    Contact findContact(FindBy findBy, String compareValue) throws NotFoundException;

    boolean removeContact(Contact contact);
}
