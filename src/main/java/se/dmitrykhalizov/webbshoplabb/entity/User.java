package se.dmitrykhalizov.webbshoplabb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private EnumSelection status;


    // ONE-TO-ONE USER - ORDER
    @OneToOne
    @JoinColumn(name="orderid")
    private Order order;

    // ONE-TO-ONE USER - CUSTOMERBASKET
    @OneToOne
    @JoinColumn(name="customerbasketid")
    private Customerbasket customerbasket;

    public User() {
    }

    public User(int userid, String firstname, String surname, String email, String address, String telephone,
                String username, String password, EnumSelection status) {
        this.userid = userid;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.status = status;

    }

    public int getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumSelection getStatus() {
        return status;
    }

    public void setStatus(EnumSelection status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customerbasket getCustomerbasket() {
        return customerbasket;
    }

    public void setCustomerbasket(Customerbasket customerbasket) {
        this.customerbasket = customerbasket;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", order=" + order +
                ", customerbasket=" + customerbasket +
                '}';
    }
}
