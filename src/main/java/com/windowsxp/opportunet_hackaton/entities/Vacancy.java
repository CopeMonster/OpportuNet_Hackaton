package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long company;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String requirements;

    @Column(nullable = false)
    private String location;

    @Enumerated(value = EnumType.STRING)
    private VacancyType vacancyType;

    private Double salary;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
