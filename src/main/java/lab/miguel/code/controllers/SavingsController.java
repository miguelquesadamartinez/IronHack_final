package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.SavingsControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.services.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SavingsController implements SavingsControllerInterface {

    @Autowired
    SavingsServiceInterface savingsServiceInterface;

    @PostMapping("/create-savings")
    @ResponseStatus(HttpStatus.OK)
    public Savings createChecking(Savings savings) {
        return savingsServiceInterface.createSavings(savings);
    }
}
