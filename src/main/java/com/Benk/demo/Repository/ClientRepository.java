package com.Benk.demo.Repository;

import com.Benk.demo.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends
        JpaRepository<Client,Long> {
}


