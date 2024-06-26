package com.clients.api.clients_api.dto;

import com.clients.api.clients_api.repository.ClientRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientTest {
    private Client client;

    @BeforeEach
    void setUp() {
        client = Client.builder()
                .id(1L)
                .docType("c")
                .docNumber(12345678)
                .firstName("Alex")
                .lastName("Beltran")
                .city("Bogota")
                .build();
    }

    @Autowired
    private ClientRespository clientRespository;

    @DisplayName("Test for find All Clients")
    @Test
    void findAllTest() {
        // Given
        Client client1 = Client.builder()
                .id(2L)
                .docType("c")
                .docNumber(45678912)
                .firstName("Jose")
                .secondName("luis")
                .lastName("Rodriguez")
                .city("Cali")
                .build();

        clientRespository.save(client);
        clientRespository.save(client1);

        // When
        List<Client> clientList = clientRespository.findAll();

        System.out.println("clientList = " + clientList);
        
        // Then
        assertThat(clientList).isNotNull();
        assertThat(clientList.size()).isEqualTo(2);
    }

    @DisplayName("Test for get an employee by Id")
    @Test
    void getClientByIdTest() {
        // Given
        clientRespository.save(client);

        // When
        Client client1 = clientRespository.findByDocTypeAndDocNumber(client.getDocType(), client.getDocNumber()).get();

        // Then
        assertThat(client1).isNotNull();
    }

    @DisplayName("Test for get an employee by Id")
    @Test
    void saveClientTest() {
        // Given
        Client newClient = Client.builder()
                .docType("p")
                .docNumber(45678912)
                .firstName("James")
                .secondName("Donald")
                .lastName("Thompson")
                .secondLastName("Jagger")
                .phone("55550123")
                .address("Main Street 11")
                .city("New York")
                .build();

        // When
        clientRespository.save(newClient);

        // Then
        assertThat(newClient).isNotNull();
        assertThat(newClient.getDocType()).isEqualTo("p");
        assertThat(newClient.getDocNumber()).isEqualTo(45678912);
        assertThat(newClient.getFirstName()).isEqualTo("James");
        assertThat(newClient.getSecondName()).isEqualTo("Donald");
        assertThat(newClient.getLastName()).isEqualTo("Thompson");
        assertThat(newClient.getSecondLastName()).isEqualTo("Jagger");
        assertThat(newClient.getPhone()).isEqualTo("55550123");
        assertThat(newClient.getAddress()).isEqualTo("Main Street 11");
        assertThat(newClient.getCity()).isEqualTo("New York");
    }

    @DisplayName("Test for delete a client")
    @Test
    void deleteClientTest() {
        // Given
        clientRespository.save(client);

        // When
        clientRespository.deleteById(client.getId());
        Optional<Client> optionalClient = clientRespository.findById(client.getId());

        // Then
        assertThat(optionalClient).isEmpty();
    }



}