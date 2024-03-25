package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;


@Entity
@Table(name="customerbasket")
public class Customerbasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerbasketid")
    private int customerbasketid;
    @Column(name="customer")
    private int customer;
    @Column(name="product")
    private int product;
    @Column(name="totalprice")
    private double totalprice;


    public Customerbasket(){
    }

    public Customerbasket(int customerbasketid, int customer, int product, double totalprice) {
        this.customerbasketid = customerbasketid;
        this.customer = customer;
        this.product = product;
        this.totalprice = totalprice;
    }

    public int getcustomerbasketid() {
        return customerbasketid;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
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
                ", customer=" + customer +
                ", product=" + product +
                ", totalprice=" + totalprice +
                '}';
    }
}
