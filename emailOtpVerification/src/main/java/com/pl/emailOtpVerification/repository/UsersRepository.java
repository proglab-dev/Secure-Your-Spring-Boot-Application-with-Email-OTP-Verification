package com.pl.emailOtpVerification.repository;

import com.pl.emailOtpVerification.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
