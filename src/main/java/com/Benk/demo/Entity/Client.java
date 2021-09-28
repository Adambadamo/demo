package com.Benk.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @SequenceGenerator(
            name = "clientSeq",
            sequenceName = "clientSeq"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "clientSeq")
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Transient
    private int age;

    @Column(name ="idCard_number")
    private String idCard;

    @Column(name ="card_number")
    private int cardNumber;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Transaction> transactionList = new ArrayList<>();

    public Client( String name,String idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public Client() {

    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        StringBuilder transactions = new StringBuilder((this.transactionList.size() == 0) ? " no transactions " : "");
        for (Transaction transaction : transactionList) transactions.append(transaction.getToCardNumber()).append("\n\t");
        return "\nClient\n Name : " + name + "\n" + transactions;
    }

}


