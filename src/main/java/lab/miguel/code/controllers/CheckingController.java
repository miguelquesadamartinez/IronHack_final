package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.CheckingControllerInterfce;
import lab.miguel.code.entity.Account;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingController implements CheckingControllerInterfce {

    @Autowired
    CheckingServiceInterface checkingService;

    @Override
    public Account createChecking(Account account) {
        return null;
    }
}
