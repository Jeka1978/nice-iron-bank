package com.naya.ironbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Evgeny Borisov
 */
@Data
@Entity
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue
    long id;
    long totalAmount;

    public Bank(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void credit(long amount){
        totalAmount -= amount;
    }

}