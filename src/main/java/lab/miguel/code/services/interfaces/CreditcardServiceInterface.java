package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.CreateCreditCardDTO;
import lab.miguel.code.entity.Creditcard;

public interface CreditcardServiceInterface {

    Creditcard createCreditcard(CreateCreditCardDTO creditcard);

}
