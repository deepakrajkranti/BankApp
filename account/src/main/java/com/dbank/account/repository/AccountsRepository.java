package com.dbank.account.repository;

import com.dbank.account.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findByMobileNumberAndActiveSw(String mobileNumber, boolean active);
}
