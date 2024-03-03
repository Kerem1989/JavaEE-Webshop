package se.dmitrykhalizov.webbshoplabb.database;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private int orderid;
    @Column(name="date")
    private LocalDate date;
    @Column(name="customer")
    private int customer;
    @Enumerated(EnumType.STRING)
    private EnumSelection status;
    @Column(name="totalprice")
    private double totalprice;

    // ONE-TO-ONE ODER - USER
    @OneToOne
    @JoinColumn(name="id")
    private User user;

    // ONE-TO-MANY ORDER - PRODUCT
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Product>products = new ArrayList<>();


    public Order() {
    }

    public Order(int id, LocalDate date, int customer, EnumSelection status, double totalprice) {
        this.orderid = orderid;
        this.date = date;
        this.customer = customer;
        this.status = status;
        this.totalprice = totalprice;
    }

    public int getorderid() {
        return orderid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public EnumSelection getStatus() {
        return status;
    }

    public void setStatus(EnumSelection status) {
        this.status = status;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", date=" + date +
                ", customer=" + customer +
                ", status=" + status +
                ", totalprice=" + totalprice +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
