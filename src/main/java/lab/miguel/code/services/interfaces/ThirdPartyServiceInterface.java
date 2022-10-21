package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.ThirdPartyDTO;
import lab.miguel.code.entity.ThirdParty;

public interface ThirdPartyServiceInterface {

    ThirdParty createThirdParty (ThirdPartyDTO thirdPartyDTO);

}
