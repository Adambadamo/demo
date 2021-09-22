package com.Benk.demo.Entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int bankID;

    @Column(name = "name")
    private String name;

    @Column(name = "accounts")
    private List<Account> accounts;

    public Bank() {

    }

    public Bank(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
