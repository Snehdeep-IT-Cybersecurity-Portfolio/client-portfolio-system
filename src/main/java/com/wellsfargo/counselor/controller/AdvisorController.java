package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {

    private final AdvisorRepository advisorRepository;

    public AdvisorController(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    @GetMapping
    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Advisor getAdvisorById(@PathVariable Long id) {
        return advisorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advisor not found with id " + id));
    }

    @PostMapping
    public Advisor createAdvisor(@RequestBody Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    @PutMapping("/{id}")
    public Advisor updateAdvisor(@PathVariable Long id, @RequestBody Advisor advisorDetails) {
        Advisor advisor = advisorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Advisor not found with id " + id));

        advisor.setAdvFirstName(advisorDetails.getAdvFirstName());
        advisor.setAdvLastName(advisorDetails.getAdvLastName());
        advisor.setAdvEmail(advisorDetails.getAdvEmail());
        advisor.setAdvPhone(advisorDetails.getAdvPhone());
        advisor.setAdvAddress(advisorDetails.getAdvAddress());

        return advisorRepository.save(advisor);
    }

    @DeleteMapping("/{id}")
    public void deleteAdvisor(@PathVariable Long id) {
        advisorRepository.deleteById(id);
    }
}
