package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Company extends User {
    private String name;

    private String description;


}
