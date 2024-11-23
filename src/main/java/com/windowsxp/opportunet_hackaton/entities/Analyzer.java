package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "analyzers")
public class Analyzer extends User {
    private String username;

    private String firstname;

    private String lastname;
}
