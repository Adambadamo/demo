package com.Benk.demo.Service;

import com.Benk.demo.Entity.Client;
import com.Benk.demo.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @PostMapping
    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    @PostMapping
    public void deleteClient(Long clientId) {
        if(!clientRepository.existsById(clientId)){
            throw new IllegalStateException(
                    "Can't find any client with this : " + clientId + " id."
            );
        } clientRepository.deleteById(clientId);
    }

}
