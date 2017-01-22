package week1_aco15.secondTry.contactApp.enums;

import java.util.HashMap;
import java.util.Map;

//TODO: always need to be update if fields are changed in Contact Model, how do support it?
public enum ContactField {
    FirstName(1, "First Name"), LastName(2, "Last Name"), PhoneNumber(3, "Phone Number");

    private static Map<Integer, ContactField> indexMap = new HashMap<Integer, ContactField>();

    static {
        for (ContactField field: values()){
            indexMap.put(field.getIndex(), field);
        }
    }

    private int index;
    private String name;

    ContactField(int index, String name){
        this.index = index;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static ContactField getField(int index){
        return indexMap.get(index);
    }
}
