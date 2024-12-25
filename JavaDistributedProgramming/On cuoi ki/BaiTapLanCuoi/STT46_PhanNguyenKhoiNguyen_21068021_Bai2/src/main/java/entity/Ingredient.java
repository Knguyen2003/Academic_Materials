package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ingredients")
public class Ingredient implements Serializable {
    @Id
    @Column(name = "ingredient_id",unique = true, nullable = false)
    private String id;
    @Column(name = "ingredient_name", nullable = false)
    private String name;
    @Column(name = "unit", nullable = false)
    private String unit;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "quantity", nullable = false)
    private double quantity;
    @Column(name = "manufacturing_date", nullable = false)
    private LocalDate manufacturingDate;
    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Item> items;

    public Ingredient() {
    }

    public Ingredient(LocalDate expiryDate, String id, LocalDate manufacturingDate, String name, double price, double quantity, String supplierName, String unit) {
        this.expiryDate = expiryDate;
        this.id = id;
        this.manufacturingDate = manufacturingDate;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "expiryDate=" + expiryDate +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturingDate=" + manufacturingDate +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}
