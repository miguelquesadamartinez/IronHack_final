package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.controllers.interfaces.AccountControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.services.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountServiceInterface accountService;

    @GetMapping("/get-account-balance")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO getBalance(Long id) {
        return accountService.getBalance(id);
    }


    @GetMapping("/transfer-to-account")
    @ResponseStatus(HttpStatus.OK)
    public void transferToAccount(@RequestParam Account origin, @RequestBody double amount, @RequestParam Optional<Account> holder1, @RequestParam Optional<Account> holder2){

        accountService.transferToAccount(origin, amount, holder1, holder2);
    }
}
