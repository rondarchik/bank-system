package com.victoria.app.core.model;
// money transfer

import javax.persistence.*;

@Entity
@Table(name = "remmitance")
public class Remittance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
