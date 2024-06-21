package com.clients.api.clients_api.service;

import com.clients.api.clients_api.dto.Client;
import com.clients.api.clients_api.dto.DocType;
import com.clients.api.clients_api.repository.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRespository clientRespository;

    public List<Client> findAll() {
        return clientRespository.findAll();
    }

    public Optional<Client> findClientByDocTypeAndDocNumber(char docType, int docNumber) {
        return clientRespository.findByDocTypeAndDocNumber(docType, docNumber);
    }

}
