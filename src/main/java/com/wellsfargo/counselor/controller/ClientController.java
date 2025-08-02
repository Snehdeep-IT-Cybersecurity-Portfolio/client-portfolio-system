package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setClientAddress(clientDetails.getClientAddress());

        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
