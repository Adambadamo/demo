package com.Benk.demo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @SequenceGenerator(
            name = "bankSeq",
            sequenceName = "bankSeq"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bankSeq")
    private Long id;

    @Column(name = "bank_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "bank_id")
    private List<Client> clientList = new ArrayList<>();

    public Bank() {

    }

    public Bank(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
