package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.controllers.DTOs.TransferDTO;
import lab.miguel.code.controllers.interfaces.AccountControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountService accountService;

    @GetMapping("/get-account-balance")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO getBalance(@RequestBody Long id) {
        return accountService.getBalance(id);
    }


    @PostMapping("/transfer-to-account")
    @ResponseStatus(HttpStatus.OK)
    public void transferToAccount(@RequestBody TransferDTO transferDTO ){
        accountService.transferToAccount(transferDTO);
    }

    @GetMapping("/get-all-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAll(){
        return accountService.findAll();
    }
}
