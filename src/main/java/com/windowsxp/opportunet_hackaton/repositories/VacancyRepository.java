package com.windowsxp.opportunet_hackaton.repositories;

import com.windowsxp.opportunet_hackaton.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
