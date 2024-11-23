package com.windowsxp.opportunet_hackaton.repositories;

import com.windowsxp.opportunet_hackaton.entities.Analyzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzerRepository extends JpaRepository<Analyzer, Long> {
}
