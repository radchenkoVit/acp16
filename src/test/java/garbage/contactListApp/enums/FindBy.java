package garbage.contactListApp.enums;

import java.util.HashMap;
import java.util.Map;

public enum FindBy {
    Name(1, "Name"), LastName(2, "Last Name"), PhoneNumber(3, "Phone Number"), Note(4, "Note");
    private static Map<String, FindBy> nameMap = new HashMap<String, FindBy>();
    private static Map<Integer, FindBy> indexMap = new HashMap<Integer, FindBy>();

    static {
        for (FindBy findBy: FindBy.values()){
            nameMap.put(findBy.name, findBy);
            indexMap.put(findBy.index, findBy);
        }
    }

    private int index;
    private String name;

    FindBy(int index, String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex(){return index;}
    public String getName(){return name;}

    public static FindBy getByIndex(int index){
        return indexMap.get(index);
    }
}
