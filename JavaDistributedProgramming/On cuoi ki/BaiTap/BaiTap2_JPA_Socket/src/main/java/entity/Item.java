package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Item.listItems", query = "select i from Ingredient as ing join ing.items as i  where i.onSpecial = true and LOWER(ing.supplierName) LIKE LOWER(:name)")

})



@Table(name = "items")
public abstract class Item implements Serializable {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    protected  String id;
    protected  String name;
    protected  double price;
    protected  String description;
    @Column(name = "on_special")
    protected  boolean onSpecial;

    @ManyToMany(mappedBy = "items")
    protected Set<Ingredient> ingredients;


    public Item() {
    }

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name, double price, String description, boolean onSpecial) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.onSpecial = onSpecial;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", onSpecial=" + onSpecial +
                '}';
    }
}
