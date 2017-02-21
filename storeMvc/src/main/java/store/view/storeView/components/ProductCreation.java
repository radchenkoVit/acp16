package store.view.storeView.components;

import store.enums.ProductField;
import store.model.Laptop;
import store.model.MobilePhone;
import store.model.Product;
import store.utils.ConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class ProductCreation {
    private ConsoleReader consoleReader;

    public ProductCreation(){
        this.consoleReader = new ConsoleReader();
    }

    private void displayProductCreationMenu(){
        System.out.println("What product would you like to add: \n1. Mobile Phone\n2. Laptop\n0. Exit\n");
    }

    public List<Product> createProducts() {
        int choice = -1;
        List<Product> list = new ArrayList<>();
        while (choice != 0){
            displayProductCreationMenu();
            System.out.print("Please, make your choice: ");
            choice = consoleReader.enterInteger();
            switch (choice){
                case 1: list.add(createMobilePhone()); System.out.println("Phone was created.\n"); break;
                case 2: list.add(createLaptop()); System.out.println("Laptop was created.\n"); break;
                case 0: System.out.println("Exit from creation mode.\n"); break;
                default:
                    System.out.println("Error: Unknown code. ");
            }
        }

        return list;
    }

    private Laptop createLaptop(){
        String name = consoleReader.enterData(1, ProductField.Name);// consoleReader.enterLine();
        Double price = Double.parseDouble(consoleReader.enterData(2, ProductField.Price)); //consoleReader.enterDouble();
        String description = consoleReader.enterData(3, ProductField.Description); //consoleReader.enterLine();
        int memory = Integer.parseInt(consoleReader.enterData(4, "RAM"));

        return new Laptop(name, price, description, memory);
    }

    private MobilePhone createMobilePhone(){
        String name = consoleReader.enterData(1, ProductField.Name);// consoleReader.enterLine();
        Double price = Double.parseDouble(consoleReader.enterData(2, ProductField.Price)); //consoleReader.enterDouble();
        String description = consoleReader.enterData(3, ProductField.Description); //consoleReader.enterLine();
        int size = Integer.parseInt(consoleReader.enterData(4, "Display Size"));

        return new MobilePhone(name, price, description, size);
    }
}
