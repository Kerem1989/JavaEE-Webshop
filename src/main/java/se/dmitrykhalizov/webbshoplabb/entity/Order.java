package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int orderid;
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "status")
    private boolean status;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    @OneToMany(mappedBy = "order")
    private Set<Orderline> orderlines = new HashSet<>();

    public Order() {
    }

    public Order(int orderid, LocalDate date, Boolean status, double total, User user, Set<Orderline> orderlines) {
        this.orderid = orderid;
        this.date = date;
        this.status = status;
        this.total = total;
        this.user = user;
        this.orderlines = orderlines;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Set<Orderline> orderlines) {
        this.orderlines = orderlines;
    }


}
