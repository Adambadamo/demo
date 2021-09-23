package com.Benk.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transactionSeq",
            sequenceName = "transactionSeq"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transactionSeq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "to_card")
    private int toCardNumber;

}
