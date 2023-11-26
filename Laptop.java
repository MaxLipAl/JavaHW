package Seminars.HomeWork.JavaHW;

import java.util.Objects;
public class Laptop {
    Brand brand;
    Color color;
    Integer ram;
    Integer hdd;
    Os os;
    public Laptop(Brand brand, Color color, int ram, int hdd, Os os) {
        this.brand = brand;
        this.color = color;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Color: %s, RAM: %d, HDD: %d, OS: %s", brand, color, ram, hdd, os);
    }

    @Override
    public boolean equals(Object obj) {
        Laptop l = (Laptop) obj;
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.brand.equals(l.brand) && this.color.equals(l.color) && this.ram.equals(l.ram) &&
                this.hdd.equals(l.hdd)  && this.os.equals(l.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.brand, this.color, this.ram, this.hdd, this.os);
    }
}

