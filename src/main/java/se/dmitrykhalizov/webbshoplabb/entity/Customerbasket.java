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

    //One-to-One relationship with user
    @OneToOne
    @JoinColumn(name="customer")
    private User user;

    @Column(name="product")
    private int product;
    @Column(name="totalprice")
    private double totalprice;

    //One-to-Many relationship with product
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customerbasket")
    private List<Product> products;

    public Customerbasket(){
    }

    public Customerbasket(int customerbasketid, User user, int product, double totalprice) {
        this.customerbasketid = customerbasketid;
        this.user = user;
        this.product = product;
        this.totalprice = totalprice;
    }

    public int getCustomerbasketid() {
        return customerbasketid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "Customerbasket{" +
                "customerbasketid=" + customerbasketid +
                ", user=" + user +
                ", product=" + product +
                ", totalprice=" + totalprice +
                '}';
    }
}
