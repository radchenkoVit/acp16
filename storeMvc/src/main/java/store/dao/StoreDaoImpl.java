package store.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import store.model.Laptop;
import store.model.MobilePhone;
import store.model.Product;
import store.utils.PropertyReader;
import store.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class StoreDaoImpl implements IStoreDao {
    private static String phoneInputPaths = Paths.get(
            "src", "main", "resources", "data", "phone.json").toString();
    private static String laptopInputPaths = Paths.get(
            "src", "main", "resources", "data", "laptop.json").toString();
    private static String productsOutputPaths = Paths.get(
            "src", "main", "resources", "data", "output", "products.json").toString();

    public Set<Product> getAllProducts() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String phonesFilePath = PropertyReader.readProperty("db.phones.path");
        String laptopsFilePath = PropertyReader.readProperty("db.laptops.path");

        String jsonPhoneAsString = StringUtils.loadFileIntoString(phonesFilePath);
        String jsonLaptopAsString = StringUtils.loadFileIntoString(laptopsFilePath);
        List<MobilePhone> phones = mapper.readValue(jsonPhoneAsString, mapper.getTypeFactory().constructCollectionType(List.class, MobilePhone.class));
        List<Laptop> laptops = mapper.readValue(jsonLaptopAsString, mapper.getTypeFactory().constructCollectionType(List.class, Laptop.class));

        Set<Product> products = new HashSet<>();
        products.addAll(phones);
        products.addAll(laptops);

        return products;
    }

public boolean saveProducts(Collection<Product> products) {
        ObjectMapper mapper = new ObjectMapper();


        try {
            mapper.writeValue(new File(productsOutputPaths), products);//TODO
        } catch (IOException e) {
            return false;
        }


        return true; //TODO
    }

    public static void createFakeDbData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        MobilePhone samsung = new MobilePhone("Samsung", 10d, "Desc", 4);
        MobilePhone htc = new MobilePhone("HTC", 20d, "Desc", 4);
        Laptop laptopHp = new Laptop("HP", 100d, "laptop", 500);
        Laptop laptopLenovo = new Laptop("Lenovo", 79d, "laptop", 486);

        List<MobilePhone> phones = Arrays.asList(samsung, htc);
        List<Laptop> laptops = Arrays.asList(laptopHp, laptopLenovo);

        mapper.writeValue(new File(phoneInputPaths), phones);
        //mapper.writeValue(new File("D:\\localRepo\\acp16\\storeMvc\\src\\main\\resources\\data\\phone.json"), phones);
        mapper.writeValue(new File(laptopInputPaths), laptops);
    }
}
