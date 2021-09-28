package com.Benk.demo.Controller;

import com.Benk.demo.Service.BankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }



}
