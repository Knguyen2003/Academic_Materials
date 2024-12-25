package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)

//@NamedQueries({
//        @NamedQuery(name = "Item.ds", query = "select i from Item i join i.ingredients ing where LOWER(ing.supplierName) like LOWER(:name) and i.onSpecial = true"),
//})



public abstract class Item implements Serializable {
    @Id
    @Column(name = "id",unique = true, nullable = false)
    protected String id;
    protected String name;
    protected double price;
    protected String description;
    @Column(name = "on_special")
    protected boolean onSpecial;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "items_ingredients",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    protected Set<Ingredient> ingredients = new HashSet<>();

    public Item() {
    }

    public Item(String description, String id, String name, boolean onSpecial, double price) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.onSpecial = onSpecial;
        this.price = price;
    }

    public Item(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", onSpecial=" + onSpecial +
                '}';
    }
}
