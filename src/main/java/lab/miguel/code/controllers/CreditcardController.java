package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.CreditcardControllerInterface;
import lab.miguel.code.services.interfaces.CreditcardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditcardController implements CreditcardControllerInterface {

    @Autowired(required = false)
    CreditcardServiceInterface creditCardService;

}
