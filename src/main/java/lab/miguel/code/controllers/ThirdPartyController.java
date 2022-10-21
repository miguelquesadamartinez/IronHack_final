package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.CreateStudentDTO;
import lab.miguel.code.controllers.DTOs.ThirdPartyDTO;
import lab.miguel.code.entity.StudentChecking;
import lab.miguel.code.entity.ThirdParty;
import lab.miguel.code.services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/create-third-pàrty")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty createThirdParty(@RequestBody ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.createThirdParty(thirdPartyDTO);
    }
}
