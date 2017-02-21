package store;

import store.controller.IStoreController;
import store.controller.StoreControllerImpl;
import store.dao.IStoreDao;
import store.dao.StoreDaoImpl;
import store.model.Product;
import store.view.storeView.IStoreView;
import store.view.storeView.StoreConsoleViewImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Run {
    public static void main(String[] args) throws IOException {
        StoreDaoImpl.createFakeDbData(); //createFakeData
        IStoreDao storeDao = new StoreDaoImpl();
        Set<Product> products = storeDao.getAllProducts();

        IStoreController controller = new StoreControllerImpl(new ArrayList<>(products));
        IStoreView applicationView = new StoreConsoleViewImpl(controller);

        applicationView.run();
        storeDao.saveProducts(products);
    }
}
