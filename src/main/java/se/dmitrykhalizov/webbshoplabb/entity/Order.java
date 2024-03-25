package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", date=" + date +
                ", customer=" + customer +
                ", status=" + status +
                ", totalprice=" + totalprice +
                ", user=" + user +
                '}';
    }
}
