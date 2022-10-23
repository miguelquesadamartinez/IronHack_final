package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateSavingsDTO;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Money;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.SavingsRepository;
import lab.miguel.code.services.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;


@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public Savings createSavings(CreateSavingsDTO savingsDTO) {

        AccountHolders accHold1 = null;
        AccountHolders accHold2 = null;

        if(savingsDTO.getPrimaryOwner() == null)
            throw new RuntimeException("No hay a owner");
        else
            accHold1 = accountHolderRepository.findById(savingsDTO.getPrimaryOwner()).get();

        if (savingsDTO.getSecondaryOwner() != null) {
            if (accountHolderRepository.findById(savingsDTO.getSecondaryOwner()).isPresent()) {
                accHold2 = accountHolderRepository.findById(savingsDTO.getSecondaryOwner()).get();
            }
        }

        Money balance = new Money(new BigDecimal(savingsDTO.getBalance()));

        Savings tempSavings = new Savings(balance, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, savingsDTO.getSecretKey(), LocalDate.now(), savingsDTO.getInterestRate(), savingsDTO.getMinimumBalance());

        return savingsRepository.save(tempSavings);
    }
}
