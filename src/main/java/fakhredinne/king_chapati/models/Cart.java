package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cart;

    @ManyToMany
    @JoinTable(
            name = "cart_meals",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;
    private int total_price=0;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Long getUserId() {
        return customer.getIdUser();
    }
    public void addPrice(int price){
        total_price+=price;
    }

    public void removePrice(int price) {
        total_price-=price;
    }
}