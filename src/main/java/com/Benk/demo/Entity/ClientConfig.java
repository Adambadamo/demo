package com.Benk.demo.Entity;

import com.Benk.demo.Repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner (ClientRepository clientRepository){
        return args -> {
            Client laci = new Client(
                    1L,
                    "Laci",
                    "laci@random.com",
                    23,
                    123456789
            );
            Client bela =new Client(
                    2L,
                    "Bela",
                    "bela@random.com",
                    21,
                    1234122789
            );
            Client sara = new Client(
                    3L,
                    "Sara",
                    "Sara@random.com",
                    19,
                    123333389
            );
            Client geza = new Client(
                    4L,
                    "Geza",
                    "geza@random.com",
                    16,
                    567234912
            );

            clientRepository.saveAll(
                    List.of(laci,bela,sara,geza)
            );
        };

    }

}

