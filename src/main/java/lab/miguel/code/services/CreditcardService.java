package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateCreditCardDTO;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Creditcard;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.CreditcardRepository;
import lab.miguel.code.services.interfaces.CreditcardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditcardService implements CreditcardServiceInterface {

    @Autowired
    CreditcardRepository creditcardRepository;


    @Override
    public Creditcard createCreditcard(CreateCreditCardDTO creditcard) {

        if(creditcard.get)

        Creditcard tempCreditCard = new Creditcard(
        creditcard.getB, AccountHolders primaryOwner, lab.miguel.code.entity.AccountHolders
        secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction, double creditLimit, double interestRate
        );

        return creditcardRepository.save(tempCreditCard);
    }
}
