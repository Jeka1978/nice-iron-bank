package com.naya.ironbank.controllers;

import com.naya.ironbank.services.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/iron-bank/api")
public class IronBankController {

    @Autowired
    private MoneyService moneyService;

    @GetMapping("/loan")
    public String loan(@RequestParam("name") String name,@RequestParam("amount") long amount) {
        long transferResult = moneyService.transfer(name, amount);
        if (transferResult == -1) {
            return "your loan is declined";
        }else {
            return name + " loan " + amount + " was approved.\n Current bank balance: " + transferResult;
        }
    }

    @GetMapping("/deposit/{amount}")
    public String deposit(@PathVariable("amount") long amount) {
        moneyService.deposit(amount);
        return "thank you";
    }
}
