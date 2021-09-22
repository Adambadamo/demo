package com.Benk.demo.Controller;

import com.Benk.demo.Entity.Client;
import com.Benk.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getClients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/newClient")
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
        System.out.println(client);
    }

    @PostMapping("/deleteClient")
    public void deleteClient(@RequestBody Client client){
        clientService.addNewClient(client);
        System.out.println(client);
    }

}
