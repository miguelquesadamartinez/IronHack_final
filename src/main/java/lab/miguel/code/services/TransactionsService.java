package lab.miguel.code.services;

import lab.miguel.code.entity.Transactions;
import lab.miguel.code.repositories.TransactionsRepository;
import lab.miguel.code.services.interfaces.TransactionsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService implements TransactionsServiceInterface {

    @Autowired
    TransactionsRepository transactionsRepository;


    @Override
    public List<Transactions> getFraudTransactions() {
        return null;
    }
}
