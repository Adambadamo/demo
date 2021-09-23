package com.Benk.demo.Entity;

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

    @Column(name ="card_number")
    private int cardNumber;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany
    @JoinColumn(name = "client_id")
    private List<Transaction> transactionList;

    public Client(Long id, String name,int cardNumber) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public Client( String name,int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public Client() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}


