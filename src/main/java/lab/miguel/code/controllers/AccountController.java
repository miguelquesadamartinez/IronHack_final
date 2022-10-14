package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.AccountControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.services.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountControllerInterface {

    @Autowired
    AccountServiceInterface accountService;

    @Override
    public Account createAccount(Account account) {

        return accountService.createAccount(account);
    }
}
