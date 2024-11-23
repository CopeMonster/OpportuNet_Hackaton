package com.windowsxp.opportunet_hackaton.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "studentVacancyRequests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentVacancyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    private String coverLetter;

    private boolean accepted;
}
