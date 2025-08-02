package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.repository.SecurityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/securities")
public class SecurityController {

    private final SecurityRepository securityRepository;

    public SecurityController(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @GetMapping
    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Security getSecurityById(@PathVariable Long id) {
        return securityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Security not found with id " + id));
    }

    @PostMapping
    public Security createSecurity(@RequestBody Security security) {
        return securityRepository.save(security);
    }

    @PutMapping("/{id}")
    public Security updateSecurity(@PathVariable Long id, @RequestBody Security securityDetails) {
        Security security = securityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Security not found with id " + id));

        security.setName(securityDetails.getName());
        security.setCategory(securityDetails.getCategory());
        security.setPurchaseDate(securityDetails.getPurchaseDate());
        security.setPurchasePrice(securityDetails.getPurchasePrice());
        security.setQuantity(securityDetails.getQuantity());
        security.setPortfolio(securityDetails.getPortfolio());

        return securityRepository.save(security);
    }

    @DeleteMapping("/{id}")
    public void deleteSecurity(@PathVariable Long id) {
        securityRepository.deleteById(id);
    }
}
