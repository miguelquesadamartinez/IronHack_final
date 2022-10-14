package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.CreditCardControllerInterface;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.CreditCard;
import lab.miguel.code.services.interfaces.CredirCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController implements CreditCardControllerInterface {

    @Autowired
    CredirCardServiceInterface creditCardService;

    @Override
    public CreditCard createCreditCard(CreditCard creditCard) {
        return null;
    }
}
