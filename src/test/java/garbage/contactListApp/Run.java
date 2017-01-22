package garbage.contactListApp;

import garbage.contactListApp.enums.FindBy;
import garbage.contactListApp.exceptions.NotFoundException;
import garbage.contactListApp.model.Contact;

import java.io.IOException;

import static garbage.contactListApp.InputString.*;
import static garbage.contactListApp.messages.Messages.FIND_BY_MESSAGE;
import static garbage.contactListApp.messages.Messages.UPDATE_MESSAGE;

public class Run {
    private static int allChoices = 5;

    public static void main(String[] args) throws IOException, NotFoundException {
        ApplicationInterface application = new ContactListApplication();

        int mainMenuChoice = -1;
        while (mainMenuChoice != 0){
            displayMainMenu();
            mainMenuChoice = enterChoice(allChoices);
            if (mainMenuChoice == 1){
                Contact contact = ContactBuilder.createContract();
                application.addContact(contact);
            } else if (mainMenuChoice == 2){
                displayMenu(FIND_BY_MESSAGE); //
                int findByChoice = enterInt();
                FindBy findByOption = FindBy.getByIndex(findByChoice);

                System.out.println(String.format("Enter: %s", findByOption.getName()));
                String findByValue = enterString();

                Contact contact = application.findContact(findByOption, findByValue);
            } else if (mainMenuChoice == 3){
                application.removeContact(new Contact());
            } else if (mainMenuChoice == 4){
                displayMenu(FIND_BY_MESSAGE);
                int findByChoice = enterInt();
                FindBy findByOption = FindBy.getByIndex(findByChoice);

                System.out.println(String.format("Enter: %s", findByOption.getName()));
                String findByValue = enterString();

                Contact contact = application.findContact(findByOption, findByValue);
                displayMenu(UPDATE_MESSAGE);
                String fieldToUpdate = enterString();
                application.updateContact(contact);
            }
        }

    }

    //TODO: don't like it
    public static void displayMainMenu(){
        System.out.println("Choice action:");
        System.out.println("1. Add contact");
        System.out.println("2. Find contact");
        System.out.println("3. Remove contact");
        System.out.println("4. Update Contact Info");
        System.out.println("5. Show all contacts");
    }



    /*
    * Display menu, based on fields of Contact class
    * */
    private static void displayMenu(String message) throws IOException {
        System.out.println(message);
        for (FindBy findBy: FindBy.values()){
            System.out.println(String.format("%d. %s", findBy.getIndex(), findBy.getName()));
        }
    }

    public static int enterChoice(int limit) throws IOException {
        String noSuchOptionError = "No such option.\nPlease, enter correct number, Attempt: %d";
        String errorMessage = "Please, enter correct number, Attempt: %d";

        for (int counter = 1; counter < 10; counter++) {
            try {
                int choice = Integer.parseInt(reader.readLine());
                if (choice > 0 && choice <= limit){
                    return choice;
                }
                System.out.println(String.format(noSuchOptionError, counter));
            } catch (NumberFormatException e) {
                System.out.println(String.format(errorMessage, counter));
            }
        }

        return -1;
    }
}
