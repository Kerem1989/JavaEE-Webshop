package se.kerem.webshop.entity;

import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "customerbasketid")
    private Customerbasket customerbasket;

    public Product() {
    }

    public Product(int productid) {
        this.productid = productid;
    }

    public Product(int productid, String name, String description, double price,
                   boolean InStock, Customerbasket customerbasket) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.InStock = InStock;
        this.customerbasket = customerbasket;
    }

    public Product(int productid, String name, String description, double price, boolean inStock, Category category) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.price = price;
        InStock = inStock;
        this.category = category;
    }

    public Product(String name, String description, double price, boolean InStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.InStock = InStock;
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

    @Override
    public String toString() {
        return name + " | " +  description;
    }
}
