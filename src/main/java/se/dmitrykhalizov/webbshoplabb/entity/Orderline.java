package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderline")
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderlineid")
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "totalprice")
    private double totalprice;

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "productid")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "ordernumber", referencedColumnName = "orderid")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    public Orderline() {
    }

    public Orderline(int id, Order order, Product product, int quantity, double totalprice) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nProduct: " + product.getName() + ", Quantity: " + quantity + ", Total price: " + totalprice;
    }
}
