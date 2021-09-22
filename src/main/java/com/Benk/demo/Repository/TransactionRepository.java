package com.Benk.demo.Repository;

import com.Benk.demo.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends
        JpaRepository<Transaction,Long> {
}
