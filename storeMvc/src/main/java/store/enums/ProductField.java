package store.enums;

import store.model.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

import static store.Messages.DEFAULT_DISPLAY_FIELD_PATTERN;

//TODO: is it good idea to implements Comparator if it implements not needed comparator for some enums
public enum ProductField implements Comparator<Product> {
    Name {
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }, Id {
        public int compare(Product o1, Product o2) {
            return o1.getId().compareTo(o2.getId());
        }
    }, Price {
        public int compare(Product o1, Product o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    }, Description {
        public int compare(Product o1, Product o2) {
            throw new UnsupportedOperationException("Can not compare nu Description Type");
        }
    }, Type {
        public int compare(Product o1, Product o2) {
            return o1.getType().compareTo(o2.getType());
        }
    };
}
