package com.clients.api.clients_api.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private char docType;
    @Column(nullable = false, unique = true)
    private Integer docNumber;
    @Column(nullable = false)
    private String firstName;
    private String secondName;

    private String lastName;
    private String secondLastName;

    private String phone;

    private String address;

    private String city;
}
