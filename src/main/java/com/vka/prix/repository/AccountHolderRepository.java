package com.vka.prix.repository;

import com.vka.prix.domain.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

  Optional<AccountHolder> findByEmail(String email);

}
