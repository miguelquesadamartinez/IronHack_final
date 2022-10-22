package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.ThirdPartyDTO;
import lab.miguel.code.entity.Money;
import lab.miguel.code.entity.ThirdParty;
import lab.miguel.code.repositories.ThirdPartyRepository;
import lab.miguel.code.services.interfaces.ThirdPartyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public ThirdParty createThirdParty(ThirdPartyDTO thirdPartyDTO) {

        return thirdPartyRepository.save(new ThirdParty(thirdPartyDTO.getHashedKey(), thirdPartyDTO.getName(), new Money(new BigDecimal(thirdPartyDTO.getAmount()))));
    }

    public ThirdParty transferToThirdParty (String hashedKey, double amount){
        ThirdParty thirdParty1 = thirdPartyRepository.findByHashedKey(hashedKey);

        thirdParty1.getBalance().increaseAmount(new BigDecimal(amount));

        return thirdPartyRepository.save(thirdParty1);

    }
}
