package com.windowsxp.opportunet_hackaton.entities;

import com.windowsxp.opportunet_hackaton.entities.enums.EmploymentType;
import com.windowsxp.opportunet_hackaton.entities.enums.ExperienceType;
import com.windowsxp.opportunet_hackaton.entities.enums.WorkScheduleType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String requirements;

    @Column(nullable = false)
    private String location;

    @Enumerated(value = EnumType.STRING)
    private ExperienceType experienceType;

    @Enumerated(value = EnumType.STRING)
    private EmploymentType employmentType;

    @Enumerated(value = EnumType.STRING)
    private WorkScheduleType workScheduleType;

    private float salary;

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
