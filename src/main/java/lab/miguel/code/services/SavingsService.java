package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateSavingsDTO;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.SavingsRepository;
import lab.miguel.code.services.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public Savings createSavings(CreateSavingsDTO savingsDTO) {

        AccountHolders accHold1 = accountHolderRepository.findById(savingsDTO.getPrimaryOwner()).get();
        AccountHolders accHold2 = accountHolderRepository.findById(savingsDTO.getSecondaryOwner()).get();

        Savings tempSavings = new Savings(500, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 0.0025, 500);

        return savingsRepository.save(tempSavings);
    }
}
