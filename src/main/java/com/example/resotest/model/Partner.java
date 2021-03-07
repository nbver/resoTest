package com.example.resotest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "partners")
@Getter
@Setter
@ToString
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column
    private String role; //employee, client
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "doc_type")
    private String docType;
    @Column(name = "doc_series")
    private String docSeries;
    @Column(name = "doc_number")
    private int docNumber;
    @Column(name = "email",
            unique = true)
    private String email;
    @Column(name = "phone_number",
            unique = true)
    private String phoneNumber;
    @Column(name = "photo")
    private String pathToPhoto;
    @Column(name = "active")
    private boolean active;
    @Column
    private String password;

    public Partner() {
    }

    public Partner(String role, String lastName, String name, String patronymic, Date birthDate, String docType, String docSeries, int docNumber, String email, String phoneNumber, String pathToPhoto, boolean active) {
        this.role = role;
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.docType = docType;
        this.docSeries = docSeries;
        this.docNumber = docNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pathToPhoto = pathToPhoto;
        this.active = active;
    }
}
