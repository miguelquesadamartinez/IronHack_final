package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateCreditCardDTO;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Creditcard;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.repositories.CreditcardRepository;
import lab.miguel.code.services.interfaces.CreditcardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditcardService implements CreditcardServiceInterface {

    @Autowired
    CreditcardRepository creditcardRepository;


    @Override
    public Creditcard createCreditcard(CreateCreditCardDTO creditcard) {



        Creditcard tempCreditCard = new Creditcard();

        return creditcardRepository.save(tempCreditCard);
    }
}
