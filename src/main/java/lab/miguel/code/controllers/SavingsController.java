package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.SavingsControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.services.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SavingsController implements SavingsControllerInterface {

    @Autowired
    SavingsServiceInterface savingsService;


    @Override
    public Savings createSavings(Savings savings) {
        return null;
    }
}
