package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.CreateAccountHolderDTO;
import lab.miguel.code.controllers.interfaces.AccountHolderControllerInterface;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountHolderController implements AccountHolderControllerInterface {


    @Autowired
    AccountHolderService accountHolderServiceInterface;

    @PostMapping("/create-account-holder")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolders createAccountHolder(@RequestBody CreateAccountHolderDTO accountHolders){
        return accountHolderServiceInterface.createAccountHolder(accountHolders);
    }

    @GetMapping("/get-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolders> findAll(){
        return accountHolderServiceInterface.findAll();
    }

    @GetMapping("/get-account-holder/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolders findById(@PathVariable Long id){
        return accountHolderServiceInterface.findById(id);
    }
}
