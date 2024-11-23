package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cvs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String filepath;

    private LocalDateTime uploadedAt;

    @OneToOne(mappedBy = "cv", cascade = CascadeType.ALL)
    private Student student;
}
