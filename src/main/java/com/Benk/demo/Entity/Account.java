package com.Benk.demo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "id")
    private int PIN;

    @Column(name = "id")
    private int PUK;

    @Column(name = "account_number")
    private int account_number;

    @Column(name = "card_number")
    private int card_number;

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Transaction> transactions = new ArrayList<>();

    public Account(Long id, Client client, String username, String password, int PIN, int PUK, int account_number, int card_number) {
        this.id = id;
        this.client = client;
        this.username = username;
        this.password = password;
        this.PIN = PIN;
        this.PUK = PUK;
        this.account_number = account_number;
        this.card_number = card_number;
    }

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", client=" + client +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", PIN=" + PIN +
                ", PUK=" + PUK +
                ", account_number=" + account_number +
                ", card_number=" + card_number +
                '}';
    }

}
