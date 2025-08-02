package com.wellsfargo.counselor.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Advisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisor_id;

    private String adv_first_name;
    private String adv_last_name;
    private String adv_email;
    private String adv_phone;
    private String adv_address;

    @OneToMany(mappedBy = "advisor")
    private List<Client> clients;

    @OneToMany(mappedBy = "advisor")
    private List<Security> securities;

    public Advisor(String adv_first_name, String adv_last_name, String adv_email, String adv_phone, String adv_address) {
        this.adv_first_name = adv_first_name;
        this.adv_last_name = adv_last_name;
        this.adv_email = adv_email;
        this.adv_phone = adv_phone;
        this.adv_address = adv_address;
    }

    public Advisor() {}

    // Getters and setters (excluding setter for advisorId)
    public Long getAdvisorId() { return advisor_id; }

    public String getAdvFirstName() { return adv_first_name; }
    public void setAdvFirstName(String adv_first_name) { this.adv_first_name = adv_first_name; }

    public String getAdvLastName() { return adv_last_name; }
    public void setAdvLastName(String adv_last_name) { this.adv_last_name = adv_last_name; }

    public String getAdvEmail() { return adv_email; }
    public void setAdvEmail(String adv_email) { this.adv_email = adv_email; }

    public String getAdvPhone() { return adv_phone; }
    public void setAdvPhone(String adv_phone) { this.adv_phone = adv_phone; }

    public String getAdvAddress() { return adv_address; }
    public void setAdvAddress(String adv_address) { this.adv_address = adv_address; }

}
