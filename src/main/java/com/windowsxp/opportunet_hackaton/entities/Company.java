package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public class Company extends User {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String BIN;
}
