package lab.miguel.code.services;

import lab.miguel.code.entity.Account;
import lab.miguel.code.repositories.AccountRepository;
import lab.miguel.code.services.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

}
