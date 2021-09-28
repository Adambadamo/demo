package com.Benk.demo.Service;

import com.Benk.demo.Entity.Bank;
import com.Benk.demo.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping
    public List<Bank> getBanks(){
        return bankRepository.findAll();
    }

    @PostMapping
    public boolean addNewBank(Bank bank) {
        if(!bankRepository.existsBankByName(bank.getName())){
            bankRepository.save(bank);
            return true;
        } return false;
    }

    @PostMapping
    public void deleteBank(Long bankId) {

        if(!bankRepository.existsById(bankId)){
            throw new IllegalStateException(
                    "Can't find any bank with this : " + bankId + " id."
            );
        } bankRepository.deleteById(bankId);
    }

}
