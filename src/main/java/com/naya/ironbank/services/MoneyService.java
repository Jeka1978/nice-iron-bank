package com.naya.ironbank.services;

/**
 * @author Evgeny Borisov
 */
public interface MoneyService {
    void deposit(long amount);

    long transfer(String name, long amount);
}
