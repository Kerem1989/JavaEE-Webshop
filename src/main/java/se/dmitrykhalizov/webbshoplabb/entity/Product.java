package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productid;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "instock")
    boolean InStock;
    @Column(name = "dispatched")
    private boolean dispatched;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "customerbasket_id")
    private Customerbasket customerbasket;

    @OneToMany(mappedBy = "product",  fetch = FetchType.EAGER)
    private List<Orderline> orderlines;

    public Product() {
    }

    public Product(int productid, String name, String description, double price,
                   boolean InStock, boolean dispatched,
                   Customerbasket customerbasket) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.InStock = InStock;
        this.dispatched = dispatched;
        this.customerbasket = customerbasket;
    }

    public Product(String name, String description, double price, boolean InStock, boolean dispatched) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.InStock = InStock;
        this.dispatched = dispatched;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return InStock;
    }

    public void setInStock(boolean inStock) {
        InStock = inStock;
    }

    public boolean isDispatched() {
        return dispatched;
    }

    public void setDispatched(boolean dispatched) {
        this.dispatched = dispatched;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Customerbasket getCustomerbasket() {
        return customerbasket;
    }

    public void setCustomerbasket(Customerbasket customerbasket) {
        this.customerbasket = customerbasket;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
