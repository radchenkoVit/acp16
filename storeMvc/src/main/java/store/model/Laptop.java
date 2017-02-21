package store.model;

import store.enums.ProductType;

public class Laptop extends Product {
    private int memory;

    public Laptop(){}

    public Laptop(String name, Double price, String description, int memory) {
        super(name, price, description, ProductType.Laptop);
        this.memory = memory;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        return memory == laptop.memory;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + memory;
        return result;
    }
}
