package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateCheckingDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Money;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.repositories.StudentRepository;
import lab.miguel.code.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AttributeOverride;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public Checking createChecking(CreateCheckingDTO checkingDTO) {

        // TODO: Lo de la cuenta por edad

        AccountHolders accHold1 = accountHolderRepository.findById(checkingDTO.getPrimaryOwner()).get();
        AccountHolders accHold2 = accountHolderRepository.findById(checkingDTO.getSecondaryOwner()).get();

        Money balance = new Money(new BigDecimal(checkingDTO.getBalance()));

        Checking tempChecking = new Checking(balance, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, checkingDTO.getSecretKey(), LocalDate.now(), checkingDTO.getMonthlyMaintenanceFee(), checkingDTO.getMinimumBalance());

        return checkingRepository.save(tempChecking);
    }

}
