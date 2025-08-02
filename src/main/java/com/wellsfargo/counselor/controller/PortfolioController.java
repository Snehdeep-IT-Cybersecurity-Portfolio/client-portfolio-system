package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    private final PortfolioRepository portfolioRepository;

    public PortfolioController(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Portfolio getPortfolioById(@PathVariable Long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id " + id));
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @PutMapping("/{id}")
    public Portfolio updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolioDetails) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id " + id));

        portfolio.setClient(portfolioDetails.getClient());
        portfolio.setCreatedDate(portfolioDetails.getCreatedDate());
        portfolio.setRiskLevel(portfolioDetails.getRiskLevel());
        portfolio.setSecurities(portfolioDetails.getSecurities());

        return portfolioRepository.save(portfolio);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioRepository.deleteById(id);
    }
}
