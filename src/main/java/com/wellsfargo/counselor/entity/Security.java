package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_id")
    private Long security_id;

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    private Portfolio portfolio;

    @Column(name = "s_name")
    private String name;

    private String category;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "purchase_price")
    private double purchasePrice;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "advisorId")
    private Advisor advisor;

    public Security() {}

    public Security(String name, String category, LocalDate purchaseDate, double purchasePrice, int quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    public Long getSecurityId() {
        return security_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
