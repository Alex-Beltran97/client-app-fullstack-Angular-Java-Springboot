package com.clients.api.clients_api.controller;

import com.clients.api.clients_api.dto.Client;
import com.clients.api.clients_api.dto.DocType;
import com.clients.api.clients_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }
    @CrossOrigin
    @GetMapping("/{docType}/{docNumber}")
    public Optional<Client> getClientByDocTypeAndDocNumber(@PathVariable char docType, @PathVariable Integer docNumber) {
        return clientService.findClientByDocTypeAndDocNumber(docType, docNumber);
    }

}
