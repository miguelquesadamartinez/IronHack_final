package lab.miguel.code.services;

import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.repositories.StudentRepository;
import lab.miguel.code.services.interfaces.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AttributeOverride;

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

}
