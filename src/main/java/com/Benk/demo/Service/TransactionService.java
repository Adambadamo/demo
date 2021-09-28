package com.Benk.demo.Service;

import com.Benk.demo.Entity.Transaction;
import com.Benk.demo.Repository.ClientRepository;
import com.Benk.demo.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository,ClientRepository clientRepository) {
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    @PostMapping
    public boolean addNewTransaction(Transaction transaction) {
        if(clientRepository.existsByCardNumber(transaction.getToCardNumber())){
            transactionRepository.save(transaction);
            return true;
        } return false;
    }

    @PostMapping
    public void deleteClient(Long clientId) {

        if(!transactionRepository.existsById(clientId)){
            throw new IllegalStateException(
                    "Can't find any client with this : " + clientId + " id."
            );
        } transactionRepository.deleteById(clientId);
    }

}
