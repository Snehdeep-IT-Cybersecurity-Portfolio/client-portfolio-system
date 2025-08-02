package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    private LocalDate createdDate;

    private String riskLevel; // e.g., "High", "Moderate", "Low"

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(Client client, LocalDate createdDate, String riskLevel) {
        this.client = client;
        this.createdDate = createdDate;
        this.riskLevel = riskLevel;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getRiskLevel() {
        return riskLevel;
    }
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<Security> getSecurities() {
        return securities;
    }
    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
