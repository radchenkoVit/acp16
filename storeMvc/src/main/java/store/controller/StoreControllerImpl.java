package store.controller;

import store.enums.ProductField;
import store.exceptions.ProductNotFoundException;
import store.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static store.Messages.NOT_FOUND_PRODUCT_BY_ID;

public class StoreControllerImpl implements IStoreController {
    private List<Product> productList; // TODO: replace by set?

    public StoreControllerImpl(List<Product> productList){
        this.productList = productList;
    }

    @Override//TODO: where data checks should be?
    public boolean addProduct(Product product) {
        if (isValid(product)){ //some validation
            return productList.add(product);
        }
        return false;
    }

    @Override//TODO: no validation here for a product
    public Product removeProduct(Product product){
        productList.remove(product);
        return product;
    }

    @Override
    public Product getProduct(String id) throws ProductNotFoundException {
        Optional<Product> foundedProduct = productList.stream().filter(product -> product.getId().equals(id)).findFirst();
        if (foundedProduct.isPresent()) return foundedProduct.get();

        throw new ProductNotFoundException(String.format(NOT_FOUND_PRODUCT_BY_ID, id));
    }

    @Override
    public List<Product> filter(String filterBy, String value) {
        return null;//TODO
    }

    @Override
    public List<Product> filterByPriceRange(Double startPrice, Double finalPrice) {
        List<Product> filtered =
                productList.stream().filter(product -> product.getPrice() >= startPrice
                && product.getPrice() <= finalPrice).collect(Collectors.toList());
        return filtered;
    }

    @Override
    public List<Product> filterByName(String name) {
        List<Product> filtered =
                productList.stream().filter(product -> product.getName().contains(name)).collect(Collectors.toList());
        return filtered;
    }

    @Override
    public List<Product> sort(ProductField field) {
        List<Product> sorted = productList.stream().sorted(field).collect(Collectors.toList());
        return sorted;
    }

    private static boolean isValid(Product product){
        if (product != null && product.getId() != null)
            return true;
        return false;
    }
}
