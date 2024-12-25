package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "foods")
@NamedQueries({
        @NamedQuery(name = "Food.listFoodAndCost", query = "select f.id, (sum(ing.price * ing.quantity) + (f.preparationTime + f.servingTime)*0.2) as giaGoc  from Food f left join f.ingredients ing  group by f.id, f.preparationTime, f.servingTime order by giaGoc desc")
})
public class Food extends Item implements Serializable {
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "preparation_time",nullable = false)
    private int preparationTime;
    @Column(name = "serving_time",nullable = false)
    private int servingTime;

    public Food(String description, String id, String name, boolean onSpecial, double price, int preparationTime, int servingTime, Type type) {
        super(description, id, name, onSpecial, price);
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
        this.type = type;
    }

    public Food(int preparationTime, int servingTime, Type type) {
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
        this.type = type;
    }

    public Food(String id, int preparationTime, int servingTime, Type type) {
        super(id);
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
        this.type = type;
    }

    public Food() {
    }

//    @Override
//    public String toString() {
//        return "Food{" +
//                "preparationTime=" + preparationTime +
//                ", type=" + type +
//                ", servingTime=" + servingTime +
//                ", price=" + price +
//                ", onSpecial=" + onSpecial +
//                ", name='" + name + '\'' +
//                ", id='" + id + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
