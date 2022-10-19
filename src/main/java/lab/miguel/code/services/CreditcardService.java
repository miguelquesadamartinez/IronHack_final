package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateCreditCardDTO;
import lab.miguel.code.entity.*;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.CreditcardRepository;
import lab.miguel.code.services.interfaces.CreditcardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CreditcardService implements CreditcardServiceInterface {

    @Autowired
    CreditcardRepository creditcardRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public Creditcard createCreditcard(CreateCreditCardDTO createCreditCardDTO) {

        AccountHolders accHold1 = accountHolderRepository.findById(createCreditCardDTO.getPrimaryOwner()).get();
        AccountHolders accHold2 = accountHolderRepository.findById(createCreditCardDTO.getSecondaryOwner()).get();

        Money balance = new Money(new BigDecimal(createCreditCardDTO.getBalance()));

        Creditcard tempCreditCard = new Creditcard(balance, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, createCreditCardDTO.getSecretKey(), LocalDate.now(), createCreditCardDTO.getCreditLimit(), createCreditCardDTO.getInterestRate());

        return creditcardRepository.save(tempCreditCard);
    }
}
