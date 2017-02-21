package store.model;

import store.enums.ProductType;

public class MobilePhone extends Product {
    private int screenSize;

    public MobilePhone(){}

    public MobilePhone(String name, Double price, String description, int screenSize) {
        super(name, price, description, ProductType.Phone);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MobilePhone that = (MobilePhone) o;

        return screenSize == that.screenSize;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + screenSize;
        return result;
    }
}
