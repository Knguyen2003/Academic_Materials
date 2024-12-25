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
    @Column(name = "ingredient_id", nullable = false, unique = true)
    private String id;
    @Column(name = "ingredient_name")
    private String name;
    private String unit;
    private double price;
    private double quantity;
    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @Column(name = "supplier_name")
    private String supplierName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "items_ingredients",
            joinColumns = @jakarta.persistence.JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "item_id")
    )
    private Set<Item> items;


    public Ingredient() {
    }

    public Ingredient(String id, String name, String unit, double price, double quantity, LocalDate manufacturingDate, LocalDate expiryDate, String supplierName, Set<Item> items) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.supplierName = supplierName;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturingDate=" + manufacturingDate +
                ", expiryDate=" + expiryDate +
                ", supplierName='" + supplierName + '\'' +
                ", items=" + items +
                '}';
    }
}
