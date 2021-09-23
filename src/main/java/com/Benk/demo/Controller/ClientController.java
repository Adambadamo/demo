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

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(
            @PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(@PathVariable("clientId")Long clientId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) int cardNumber){
            clientService.updateClient(clientId,name,cardNumber);
    }

}
