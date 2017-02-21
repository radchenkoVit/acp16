package store.view.storeView;

import store.model.Product;

import java.util.List;

public interface IStoreView {
    void run();
    //TODO: should it be method with parameters in method signature, should data creates in view's methods?
    void addProduct();

    void removeProduct();

    void getProduct();

    void filterProduct();

    void filterByPriceRange();

    void filterByName();

    void sortProduct();
}
