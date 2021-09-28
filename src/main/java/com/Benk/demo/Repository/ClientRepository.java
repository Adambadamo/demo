package com.Benk.demo.Repository;

import com.Benk.demo.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends
        JpaRepository<Client,Long> {

    //@Query("SELECT c FROM Client c WHERE c.name = ")
    Optional<Client> findClientByName(String name);
    boolean existsClientByNameAndIdCard(String name,String idCard);
    boolean existsByCardNumber(int cardNumber);
}


