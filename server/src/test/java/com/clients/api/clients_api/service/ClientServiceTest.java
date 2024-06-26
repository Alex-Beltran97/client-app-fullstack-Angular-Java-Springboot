package com.clients.api.clients_api.service;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

import com.clients.api.clients_api.dto.Client;
import com.clients.api.clients_api.exception.BadRequestException;
import com.clients.api.clients_api.exception.ClientNotFoundException;
import com.clients.api.clients_api.repository.ClientRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    private Client client;

    @Mock
    private ClientRespository clientRespository;

    @InjectMocks
    private ClientService clientService;

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

    @DisplayName("Test for get client list")
    @Test
    void getAllClientsTest() {
        // Given
        Client client1 = Client.builder()
                .id(2L)
                .docType("p")
                .docNumber(13467952)
                .firstName("Jhon")
                .lastName("Emerson")
                .city("Seattle")
                .build();
        given(clientRespository.findAll()).willReturn(List.of(client1, client));

        // When
        List<Client> clientList = clientService.findAll();

        // Then
        assertThat(clientList).isNotNull();
        assertThat(clientList.size()).isEqualTo(2);
    }

    @DisplayName("Test for get client by docType and docNumber")
    @Test
    void getClientByDocTypeAndDocNumber() throws ClientNotFoundException, BadRequestException {
        // Given
        given(clientRespository.findByDocTypeAndDocNumber("c", 12345678)).willReturn(Optional.of(client));

        // When
        Client savedClient = clientService.findClientByDocTypeAndDocNumber(client.getDocType().toLowerCase(), client.getDocNumber());

        // Then
        assertThat(savedClient).isNotNull();
    }

    @DisplayName("Test for create a client")
    @Test
    void createClientTest() throws BadRequestException {
        // Given
        Client client1 = Client.builder()
                .id(2L)
                .docType("p")
                .docNumber(13467952)
                .firstName("Jhon")
                .lastName("Emerson")
                .city("Seattle")
                .build();
        given(clientRespository.save(client1)).willReturn(client1);

        // When
        Client newClient = clientService.saveClient(client1);

        // Then
        assertThat(newClient).isNotNull();
        assertThat(newClient.getDocType()).isEqualTo("p");
        assertThat(newClient.getDocNumber()).isEqualTo(13467952);
        assertThat(newClient.getFirstName()).isEqualTo("Jhon");
        assertThat(newClient.getLastName()).isEqualTo("Emerson");
        assertThat(newClient.getCity()).isEqualTo("Seattle");
    }

    @DisplayName("Test for delete client")
    @Test
    void deleteClientTest() throws ClientNotFoundException {
        // Given
        Long id = 1L;
        String docType = "c";
        Integer docNumber = 12345678;
        given(clientRespository.findByDocTypeAndDocNumber(docType, docNumber)).willReturn(Optional.of(client));
        willDoNothing().given(clientRespository).deleteById(id);

        // When
        clientService.deleteClient(docType, docNumber);

        // Then
        verify(clientRespository, times(1)).deleteById(id);

    }

}
