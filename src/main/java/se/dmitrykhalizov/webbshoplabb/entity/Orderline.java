package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

@Entity
@Table(name="orderline")
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderlineid")
    private int id;
    @Column(name="order")
    private int order;
    @Column(name="quantity")
    private int quantity;
    @Column(name="totalprice")
    private double totalprice;

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "productid", nullable = false)
    private Product product;


    public Orderline() {
    }

    public Orderline(int id, int order, Product product, int quantity, double totalprice) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }


    @Override
    public String toString() {
        return "Orderline{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalprice=" + totalprice +

                '}';
    }
}
