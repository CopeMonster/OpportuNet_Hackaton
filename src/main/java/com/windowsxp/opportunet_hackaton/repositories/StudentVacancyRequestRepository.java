package com.windowsxp.opportunet_hackaton.repositories;

import com.windowsxp.opportunet_hackaton.entities.StudentVacancyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentVacancyRequestRepository extends JpaRepository<StudentVacancyRequest, Long> {
}
