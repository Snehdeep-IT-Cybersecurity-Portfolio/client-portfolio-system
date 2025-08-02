package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    private String client_first_name;
    private String client_last_name;
    private String client_email;
    private String client_phone;
    private String client_address;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    public Client() {}

    public Client(String client_first_name, String client_last_name, String client_email, String client_phone, String client_address, Advisor advisor) {
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
        this.client_email = client_email;
        this.client_phone = client_phone;
        this.client_address = client_address;
        this.advisor = advisor;
    }

    public Long getClientId() {
        return client_id;
    }

    public String getFirstName() {
        return client_first_name;
    }
    public void setFirstName(String client_first_name) {
        this.client_first_name = client_first_name;
    }

    public String getLastName() {
        return client_last_name;
    }
    public void setLastName(String client_last_name) {
        this.client_last_name = client_last_name;
    }

    public String getEmail() {
        return client_email;
    }
    public void setEmail(String client_email) {
        this.client_email = client_email;
    }

    public String getPhone() {
        return client_phone;
    }
    public void setPhone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getClientAddress() {
        return client_address;
    }
    public void setClientAddress(String client_address) {
        this.client_address = client_address;
    }

    public Advisor getAdvisor() {
        return advisor;
    }
    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
