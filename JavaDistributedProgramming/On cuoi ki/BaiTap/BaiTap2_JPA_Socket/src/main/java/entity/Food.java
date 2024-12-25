package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "foods")
@NamedQueries({
        @NamedQuery(name = "Food.listFoodAndCost", query = "select f.id, (Sum(ing.quantity*ing.price) + (f.preparationTime + f.servingTime)*0.2) as giaGoc from Food as f left join f.ingredients as ing group by f.id, f.preparationTime, f.servingTime order by giaGoc desc")
})


public class Food extends Item implements Serializable {
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "preparation_time")
    private int preparationTime;
    @Column(name = "serving_time")
    private int servingTime;


    public Food() {
    }

    public Food(Type type, int preparationTime, int servingTime) {
        this.type = type;
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
    }

    public Food(String id, String name, double price, String description, boolean onSpecial, Type type, int preparationTime, int servingTime) {
        super(id, name, price, description, onSpecial);
        this.type = type;
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
    }

    public Food(String id, Type type, int preparationTime, int servingTime) {
        super(id);
        this.type = type;
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
    }

    @Override
    public String toString() {
        return "Food{" +
                "type=" + type +
                ", preparationTime=" + preparationTime +
                ", servingTime=" + servingTime +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", onSpecial=" + onSpecial +
                '}';
    }
}
