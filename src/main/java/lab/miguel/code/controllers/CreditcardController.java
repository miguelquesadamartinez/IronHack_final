package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.CreditcardControllerInterface;
import lab.miguel.code.entity.Creditcard;
import lab.miguel.code.services.CreditcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditcardController implements CreditcardControllerInterface {
    @Autowired
    CreditcardService creditCardService;

    @PostMapping("/create-credit-card")
    @ResponseStatus(HttpStatus.OK)
    public Creditcard createChecking(Creditcard creditcard) {
        return creditCardService.createCreditcard(creditcard);
    }
}
