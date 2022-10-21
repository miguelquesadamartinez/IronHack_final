package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.CreateCheckingDTO;
import lab.miguel.code.controllers.interfaces.CheckingControllerInterfce;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.services.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CheckingController implements CheckingControllerInterfce {

    @Autowired
    CheckingService checkingService;

    @PostMapping("/create-checking")
    @ResponseStatus(HttpStatus.OK)
    public Checking createChecking(@RequestBody CreateCheckingDTO createCheckingDTO) {
        System.err.println("ANTES DE EL FIND createChecking");
        System.err.println(createCheckingDTO.getPrimaryOwner());
        System.err.println(createCheckingDTO.getSecondaryOwner());
        System.err.println(createCheckingDTO.getSecretKey());
        return checkingService.createChecking(createCheckingDTO);
    }

}
