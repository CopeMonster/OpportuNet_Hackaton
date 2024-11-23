package com.windowsxp.opportunet_hackaton.repositories;

import com.windowsxp.opportunet_hackaton.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
