package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "beverages")
public class Beverage extends Item implements Serializable {
    @Enumerated(EnumType.STRING)
    private Size size;
    @Column(name = "supplier_name")
    private String supplierName;

    public Beverage(Size size, String supplierName) {
        this.size = size;
        this.supplierName = supplierName;
    }

    public Beverage(String description, String id, String name, boolean onSpecial, double price, Size size, String supplierName) {
        super(description, id, name, onSpecial, price);
        this.size = size;
        this.supplierName = supplierName;
    }

    public Beverage(String id, Size size, String supplierName) {
        super(id);
        this.size = size;
        this.supplierName = supplierName;
    }

    public Beverage() {
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "size=" + size +
                ", supplierName='" + supplierName + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", onSpecial=" + onSpecial +
                ", price=" + price +
                '}';
    }
}
