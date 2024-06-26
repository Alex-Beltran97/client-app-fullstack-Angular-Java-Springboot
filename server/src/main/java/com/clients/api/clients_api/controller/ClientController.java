package com.clients.api.clients_api.controller;

import com.clients.api.clients_api.dto.Client;
import com.clients.api.clients_api.exception.BadRequestException;
import com.clients.api.clients_api.exception.ClientNotFoundException;
import com.clients.api.clients_api.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }
    @CrossOrigin
    @GetMapping("/{docType}/{docNumber}")
    public Client getClientByDocTypeAndDocNumber(@PathVariable String docType, @PathVariable Integer docNumber) throws ClientNotFoundException, BadRequestException {
        return clientService.findClientByDocTypeAndDocNumber(docType, docNumber);
    }
    @CrossOrigin
    @PostMapping
    public void createClient(@Valid @RequestBody Client client) throws BadRequestException {
        clientService.saveClient(client);
    }
    @CrossOrigin
    @DeleteMapping("/{docType}/{docNumber}")
    public void deleteClient(@PathVariable String docType, @PathVariable Integer docNumber) throws ClientNotFoundException {
        clientService.deleteClient(docType, docNumber);
    }

}
