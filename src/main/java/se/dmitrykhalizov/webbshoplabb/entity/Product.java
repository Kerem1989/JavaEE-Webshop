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
    @Column(name = "quantity")
    private int quantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnumSelection status;


    @ManyToOne
    @JoinColumn(name = "customerbasket_id")
    private Customerbasket customerbasket;


    @OneToMany(mappedBy = "product")
    private List<Orderline> orderlines;

    public Product() {
    }

    public Product(int productid, String name, String description, double price,
                   int quantity, EnumSelection status,
                   Customerbasket customerbasket) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.customerbasket = customerbasket;
    }

    public Product(String name, String description, double price, int quantity, EnumSelection status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getProductid() {
        return productid;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public EnumSelection getStatus() {
        return status;
    }

    public void setStatus(EnumSelection status) {
        this.status = status;
    }

    public Customerbasket getCustomerbasket() {
        return customerbasket;
    }

    public void setCustomerbasket(Customerbasket customerbasket) {
        this.customerbasket = customerbasket;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status=" + status +
                ", customer basket=" + customerbasket.getCustomerbasketid() +
                '}';
    }
}
