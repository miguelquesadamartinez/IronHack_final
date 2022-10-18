package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.AccountIdDTO;
import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.controllers.DTOs.TransferDTO;
import lab.miguel.code.controllers.interfaces.AccountControllerInterface;
import lab.miguel.code.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController implements AccountControllerInterface {
    @Autowired
    AccountService accountService;

    @GetMapping("/get-account-balance")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO getBalance(@RequestParam Long id) {
        return accountService.getBalance(id);
    }


    @PostMapping("/transfer-to-account")
    @ResponseStatus(HttpStatus.OK)
    public void transferToAccount( @RequestParam TransferDTO transferDTOM ){

        accountService.transferToAccount(transferDTOM);
    }
}
