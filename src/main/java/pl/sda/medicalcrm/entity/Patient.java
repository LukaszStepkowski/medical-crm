package pl.sda.medicalcrm.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

    @Entity
    @Table(name = "patient")
//    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//    @DiscriminatorColumn(name = "customer_type")


    public class Patient {

        @Id
        private UUID id;
        private String name;
        private String surname;
        private int PESEL;
        private String Email_login;
        private String password;


        }

