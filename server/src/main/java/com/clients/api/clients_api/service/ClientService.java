package com.clients.api.clients_api.service;

import com.clients.api.clients_api.dto.Client;
import com.clients.api.clients_api.exception.BadRequestException;
import com.clients.api.clients_api.exception.ClientNotFoundException;
import com.clients.api.clients_api.repository.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRespository clientRespository;

    // Getting all clients created
    public List<Client> findAll() {
        return clientRespository.findAll();
    }

    // Find clients by their document type and document number
    public Client findClientByDocTypeAndDocNumber(String docType, Integer docNumber) throws ClientNotFoundException, BadRequestException {
        Optional<Client> client = clientRespository.findByDocTypeAndDocNumber(docType.toLowerCase(), docNumber);

        String docNumberStr = String.valueOf(docNumber);

        if (docNumberStr.length() < 8 || docNumberStr.length() > 11) {
            throw new BadRequestException("docNumber must be between 8 and 11 characters");
        };

        if (!docType.equalsIgnoreCase("c") && !docType.equalsIgnoreCase("p")) {
            throw new BadRequestException("docType not valid, set either 'C' or 'P'");
        };

        if (client.isEmpty()) {
            throw new ClientNotFoundException("Client not found!");
        };

        return client.get();
    }

    // Creating clients into database
    public Client saveClient(Client client) throws BadRequestException {
        if (!client.getDocType().equalsIgnoreCase("c") && !client.getDocType().equalsIgnoreCase("p")) {
            throw new BadRequestException("docNumber must be either 'C' or 'P'");
        }
        client.setDocType(client.getDocType().toLowerCase());
        clientRespository.save(client);
        return client;
    }
    public void deleteClient(String docType, Integer docNumber) throws ClientNotFoundException {
        Optional<Client> client = clientRespository.findByDocTypeAndDocNumber(docType.toLowerCase(), docNumber);
        if (client.isEmpty()) {
            throw new ClientNotFoundException("Client not found!");
        };
        clientRespository.deleteById(client.get().getId());
    }

}
