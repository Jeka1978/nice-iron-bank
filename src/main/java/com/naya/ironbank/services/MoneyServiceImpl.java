package com.naya.ironbank.services;

import com.naya.ironbank.dao.MoneyDao;
import com.naya.ironbank.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Evgeny Borisov
 */
@Service
@RequiredArgsConstructor
@Transactional
public class MoneyServiceImpl implements MoneyService {
    private final MoneyDao moneyDao;
    private final ProphetService prophetService;

    @EventListener(ContextRefreshedEvent.class)
    void fillBank() {
        moneyDao.save(new Bank(100000));
    }

    @Override
    public void deposit(long amount) {
        Bank bank = moneyDao.findAll().get(0);
        bank.setTotalAmount(amount+bank.getTotalAmount());
    }


    @Override
    public long transfer(String name, long amount) {
        Bank bank = moneyDao.findAll().get(0);
        if (bank.getTotalAmount() - amount > 0 && prophetService.willSurvive(name)) {
            bank.credit(amount);
            return moneyDao.save(bank).getTotalAmount();
        }else {
            return -1;
        }
    }
}
