package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.CheckingControllerInterfce;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.services.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckingController implements CheckingControllerInterfce {

    @Autowired
    CheckingService checkingService;

    @PostMapping("/create-checking")
    @ResponseStatus(HttpStatus.OK)
    public Checking createChecking(Checking checking) {
        return checkingService.createChecking(checking);
    }

}
