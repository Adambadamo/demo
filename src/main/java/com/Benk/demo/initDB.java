package com.Benk.demo;

import com.Benk.demo.Entity.Bank;
import com.Benk.demo.Entity.Client;
import com.Benk.demo.Repository.BankRepository;
import com.Benk.demo.Repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class initDB {
    private static final Logger log = LoggerFactory.getLogger(initDB.class);

    @Bean
    CommandLineRunner loadBanks(BankRepository bankRepository) {
        return args -> {
            try {
                log.info("New Bank: " + bankRepository.save(new Bank("Csabacsud bank")).getName());
                log.info("New Bank: " + bankRepository.save(new Bank("Kardos bank")).getName());
            }catch (Exception e){
                log.error("Error?: "+e.getMessage());
            }
        };
    }

    @Bean
    CommandLineRunner loadClients(ClientRepository clientRepository) {
        return args -> {
            try {
                log.info("New client: " + clientRepository.save(new Client("Sanyi","000AAA")).getName());
                log.info("New client: " + clientRepository.save(new Client("Mari","000AAB")).getName());
                log.info("New client: " + clientRepository.save(new Client("Andi","000AAC")).getName());
                log.info("New client: " + clientRepository.save(new Client("Kati","000AAD")).getName());
                log.info("New client: " + clientRepository.save(new Client("Ancsa","000AAE")).getName());
                log.info("New client: " + clientRepository.save(new Client("Márk","000AAF")).getName());
                log.info("New client: " + clientRepository.save(new Client("Geza","000AAG")).getName());
                log.info("New client: " + clientRepository.save(new Client("Bela","000AAH")).getName());
                log.info("New client: " + clientRepository.save(new Client("Pista","000AAI")).getName());
                log.info("New client: " + clientRepository.save(new Client("Laci","000AAJ")).getName());
            }catch (Exception e){
                log.error("Error?: "+e.getMessage());
            }
        };
    }

}
