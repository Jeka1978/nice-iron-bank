package com.naya.ironbank.dao;

import com.naya.ironbank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evgeny Borisov
 */
public interface MoneyDao extends JpaRepository<Bank,Long> {
}
