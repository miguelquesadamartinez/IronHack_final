package lab.miguel.code.controllers;

import lab.miguel.code.entity.Transactions;
import lab.miguel.code.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionsService transactionsService;

    @GetMapping("/get-fraud")
    @ResponseStatus(HttpStatus.OK)
    public List<Transactions> getFraudTransactions(){
        return transactionsService.getFraudTransactions();
    }

}
