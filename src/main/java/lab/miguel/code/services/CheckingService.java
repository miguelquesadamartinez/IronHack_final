package lab.miguel.code.services;

import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.repositories.StudentRepository;
import lab.miguel.code.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AttributeOverride;
import java.util.Optional;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Checking createChecking(Checking checking) {

        // TODO: Lo de la cuenta por edad

        return  checkingRepository.save(checking);
    }

    @Override
    public void transferToAccount(Checking origin, double amount, Optional<AccountHolders> holder1, Optional<AccountHolders> holder2) {

        if (origin.getBalance() < amount)
            throw new RuntimeException("Cantidad superior a balance");

        if(holder1.isPresent()) {

        } else if (holder2.isPresent()){

        }
    }
}
