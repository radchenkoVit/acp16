package week1_aco15.secondTry.contactApp.view;

import week1_aco15.secondTry.contactApp.enums.ContactField;
import week1_aco15.secondTry.contactApp.enums.MobileOperator;
import week1_aco15.secondTry.contactApp.model.Contact;
import week1_aco15.secondTry.contactApp.model.Pair;

import java.io.IOException;
import java.util.List;

public interface IContactListView {
    void showAllContacts(List<Contact> contactList);

    void showFirstFiveContacts(List<Contact> contactList);

    void showLastFiveContacts(List<Contact> contactList);

    //will replace: showLifeContacts, showKievStarContacts
    void showContacts(MobileOperator operator, List<Contact> contactList);

    void showContactFields(List<Contact> contactList);

    //methods by view to get data
    Contact createContact() throws IOException;

    Pair getContactToFind() throws IOException;

    Pair<ContactField, String> getContactToRemove() throws IOException;
}
