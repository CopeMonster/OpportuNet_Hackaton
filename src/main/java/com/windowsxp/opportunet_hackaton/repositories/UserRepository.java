package com.windowsxp.opportunet_hackaton.repositories;

import com.windowsxp.opportunet_hackaton.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
