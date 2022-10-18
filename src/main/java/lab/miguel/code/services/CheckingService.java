package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateCheckingDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.repositories.StudentRepository;
import lab.miguel.code.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AttributeOverride;
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



        Checking tempChecking = new Checking(500, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 0, 100);

        return  checkingRepository.save(tempChecking);
    }

}
