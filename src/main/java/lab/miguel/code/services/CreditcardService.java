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

        AccountHolders accHold1 = null;
        AccountHolders accHold2 = null;

        if (!accountHolderRepository.findById(createCreditCardDTO.getPrimaryOwner()).isPresent()
                &&
                !accountHolderRepository.findById(createCreditCardDTO.getSecondaryOwner()).isPresent())
            throw new RuntimeException("No hay a owner");

        System.err.println("ENTRo createCreditcard");

        accHold1 = accountHolderRepository.findById(createCreditCardDTO.getPrimaryOwner()).get();

        System.err.println("PASO 1");

        if(accountHolderRepository.findById(createCreditCardDTO.getSecondaryOwner()).isPresent()) {
            System.err.println("PASO 2");
            accHold2 = accountHolderRepository.findById(createCreditCardDTO.getSecondaryOwner()).get();
        }


        // TODO: Tal vez

        Money balance = new Money(new BigDecimal(createCreditCardDTO.getBalance()));

        Creditcard tempCreditCard = new Creditcard(balance, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, createCreditCardDTO.getSecretKey(), LocalDate.now(), createCreditCardDTO.getCreditLimit(), createCreditCardDTO.getInterestRate());

        return creditcardRepository.save(tempCreditCard);
    }
}
