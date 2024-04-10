package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="customerbasket")
public class Customerbasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerbasketid")
    private int customerbasketid;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @ManyToOne
    @JoinColumn(name="productid")
    private Product product;

    private int quantity;

    public Customerbasket() {
    }

    public Customerbasket(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public Customerbasket(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getCustomerbasketid() {
        return customerbasketid;
    }

    public void setCustomerbasketid(int customerbasketid) {
        this.customerbasketid = customerbasketid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Customerbasket{" +
                "customerbasketid=" + customerbasketid +
                ", user=" + user.getUsername() +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
