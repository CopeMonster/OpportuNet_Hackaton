package com.windowsxp.opportunet_hackaton.repositories;

import com.windowsxp.opportunet_hackaton.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
