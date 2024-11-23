package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Company extends User {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String BIN;

    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Vacancy> vacancies;
}
