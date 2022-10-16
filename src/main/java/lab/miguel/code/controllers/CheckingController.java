package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.CheckingControllerInterfce;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CheckingController implements CheckingControllerInterfce {

    @Autowired
    CheckingServiceInterface checkingService;

    @PostMapping("/create-checking")
    @ResponseStatus(HttpStatus.OK)
    public Checking createChecking(Checking checking) {
        return checkingService.createChecking(checking);
    }

}
