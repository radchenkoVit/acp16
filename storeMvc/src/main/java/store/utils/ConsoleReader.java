package store.utils;

import store.enums.ProductField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX_ATTEMPT_NUMBER = 3;

    //TODO: hm? better way?
    public Double enterDouble()  {
        Double value = null;

        for (int count = 1;  value == null; count++){
            if (count == MAX_ATTEMPT_NUMBER){
                System.out.println("Error: ...");
                break;
                //throw Exception
            }
            try {
                String valueAsString = reader.readLine();
                value = Double.parseDouble(valueAsString);
            } catch (IOException e) {
                System.out.print("Error reading value. Please, enter again: ");
            } catch (NumberFormatException e){
                System.out.print("Error parsing: Wrong format. Not Double. Please, enter again: ");
            }
        }

        return value;
    }

    public String enterLine()  {
        String value = null;

        for (int count = 1;  value == null; count++) {
            if (count == MAX_ATTEMPT_NUMBER) {
                System.out.println("Error: ...");
                break;
                //or throw Exception
            }
            try {
                value = reader.readLine();
            } catch (IOException e) {
                System.out.print("Error reading value. Please, enter again: ");
            }
        }

        return value;
    }

    public Integer enterInteger() {
        Integer value = null;

        for (int count = 1;  value == null; count++){
            if (count == MAX_ATTEMPT_NUMBER){
                System.out.println("Error: ...");
                break;
                //throw Exception
            }
            try {
                String valueAsString = reader.readLine();
                value = Integer.parseInt(valueAsString);
            } catch (IOException e) {
                System.out.print("Error reading value. Please, enter again: ");
            } catch (NumberFormatException e){
                System.out.print("Error parsing: Wrong format. Not Integer. Please, enter again: ");
            }
        }

        return value;
    }

    //TODO: change for creation product
    public  String enterData(int index, String fieldName)  {
        System.out.print(String.format("%d. %s: ", index, fieldName));
        return enterLine();
    }

    public  String enterData(int index, ProductField field)  {
        System.out.print(String.format("%d. %s: ", index, field.name()));
        return enterLine();
    }
}
