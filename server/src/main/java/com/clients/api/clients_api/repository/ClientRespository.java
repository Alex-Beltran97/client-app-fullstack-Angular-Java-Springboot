package com.clients.api.clients_api.repository;

import com.clients.api.clients_api.dto.Client;
import com.clients.api.clients_api.dto.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRespository extends JpaRepository<Client, Long> {
    public Optional<Client> findByDocTypeAndDocNumber(char docType, Integer docNumber);
}
