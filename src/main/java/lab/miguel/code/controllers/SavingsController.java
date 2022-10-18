package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.CreateSavingsDTO;
import lab.miguel.code.controllers.interfaces.SavingsControllerInterface;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.services.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavingsController implements SavingsControllerInterface {

    @Autowired
    SavingsService savingsService;

    @PostMapping("/create-savings")
    @ResponseStatus(HttpStatus.OK)

    // TODO: Aqui hay un problema, sin @RequestBody me lo crea, pero vacio
    public Savings createSavings(@RequestBody CreateSavingsDTO savings) {

        return savingsService.createSavings(savings);
    }
}
