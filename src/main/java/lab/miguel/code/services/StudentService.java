package lab.miguel.code.services;

import lab.miguel.code.entity.StudentChecking;
import lab.miguel.code.repositories.StudentRepository;
import lab.miguel.code.services.interfaces.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentChecking createStudent(StudentChecking studentChecking) {
        return studentRepository.save(studentChecking);
    }
}
