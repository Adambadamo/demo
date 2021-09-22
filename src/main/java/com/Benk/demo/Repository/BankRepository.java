package com.Benk.demo.Repository;

import com.Benk.demo.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends
        JpaRepository<Bank,Long> {
}
