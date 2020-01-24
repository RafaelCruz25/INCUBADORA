package com.invillia.entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.StringJoiner;


@Entity
@Table(name = "account")
public  class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="holder_account", nullable = false, length = 255)
    private String holder;

    @Column(name="balance", nullable = false)
    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name="type_account", nullable = false, length = 255)
    private TypeAccount typeAccount;

    @Column(name="loan_limit", nullable = false)
    private Double loanLimit;

    @CreationTimestamp
    @Column(name= "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Account(){
    }

    public Account(String holder, Double balance, TypeAccount typeAccount) {
        this.holder = holder;
        this.balance = balance;
        this.typeAccount = typeAccount;
        this.loanLimit = typeAccount.loanLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }

    public void withdraw(Double amount){

        if(typeAccount.equals("CHECKINGACCOUNT")) {
            if (this.balance > 0 && this.balance <= amount) {
                this.balance -= amount;
            } else if (this.balance + this.loanLimit >= amount) {
                this.balance -= amount;
            } else {
                System.out.println("VALOR INVALIDO!");
            }
        }
        else{
            if(this.balance > 0 && amount <= this.balance){
                this.balance -= amount;
            }
            else{
                System.out.println("VALOR INVALIDO!");
                System.out.println("CONTA NÃO POSSUI LIMITE DISPONIVEL!");
            }

        }

    }

    public void deposit(Double amount){
        this.balance += amount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]\n")
                .add("id=" + id)
                .add("holder='" + holder + "'")
                .add("balance=" + balance)
                .add("typesAccounts=" + typeAccount)
                .add("loanLimit=" + loanLimit)
                .add("createdAt=" + createdAt)
                .add("updatedAt=" + updatedAt)
                .toString();
    }
}
