package store.dao;

import store.model.Product;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public interface IStoreDao {
    Set<Product> getAllProducts() throws IOException;

    boolean saveProducts(Collection<Product> products);

}
