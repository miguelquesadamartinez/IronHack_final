package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.CreateStudentDTO;
import lab.miguel.code.controllers.DTOs.ThirdPartyDTO;
import lab.miguel.code.entity.StudentChecking;
import lab.miguel.code.entity.ThirdParty;
import lab.miguel.code.services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/create-third-pàrty")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty createThirdParty(@RequestBody ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.createThirdParty(thirdPartyDTO);
    }

    @PostMapping("pay-third-party")
    public ThirdParty payThirdPartyDos(@RequestHeader(name = "hashedKey", required = true) String hashedKey,
                                                @RequestBody ThirdPartyDTO thirdPartyDTO){

        return thirdPartyService.transferToThirdParty(hashedKey, thirdPartyDTO.getAmount());
    }
    @PostMapping("/transfer-to-third-party")
    public ThirdParty transeferToThirdParty(@RequestBody ThirdPartyDTO thirdPartyDTO){
        return thirdPartyService.transferToThirdParty(thirdPartyDTO.getHashedKey(), thirdPartyDTO.getAmount());
    }

}
