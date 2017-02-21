package store.controller;

import store.enums.ProductField;
import store.exceptions.ProductNotFoundException;
import store.model.Product;

import java.util.Collection;
import java.util.List;

public interface IStoreController {
    boolean addProduct(Product product);

    Product removeProduct(Product product);

    Product getProduct(String id) throws ProductNotFoundException;

    //TODO: is there a way to make smart sorting based on class fields?
    List<Product> filter(String filterBy, String value);

    List<Product> filterByPriceRange(Double startPrice, Double finalPrice);

    List<Product> filterByName(String name); //etc. other filters - same logic

    List<Product> sort(ProductField field);
}
