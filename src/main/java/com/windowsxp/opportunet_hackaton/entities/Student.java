package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student extends User {
    private String username;

    private String firstname;

    private String lastname;
}
