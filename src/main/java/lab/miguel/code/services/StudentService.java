package lab.miguel.code.services;

import lab.miguel.code.controllers.DTOs.CreateStudentDTO;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Money;
import lab.miguel.code.entity.Savings;
import lab.miguel.code.entity.StudentChecking;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.AccountHolderRepository;
import lab.miguel.code.repositories.StudentRepository;
import lab.miguel.code.services.interfaces.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public StudentChecking createStudent(CreateStudentDTO createStudentDTO) {


        AccountHolders accHold1 = accountHolderRepository.findById(createStudentDTO.getPrimaryOwner()).get();
        AccountHolders accHold2 = accountHolderRepository.findById(createStudentDTO.getSecondaryOwner()).get();

        Money balance = new Money(new BigDecimal(createStudentDTO.getBalance()));


        StudentChecking tempStudent = new StudentChecking(balance, accHold1, accHold2, LocalDate.now(), Status.ACTIVE, createStudentDTO.getSecretKey(), LocalDate.now());

        return studentRepository.save(tempStudent);
    }
}
