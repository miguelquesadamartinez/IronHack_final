package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.controllers.interfaces.AccountControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.services.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountServiceInterface accountService;

    @GetMapping("/get-balance")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO getBalance(Long id) {
        return accountService.getBalance(id);
    }

}
