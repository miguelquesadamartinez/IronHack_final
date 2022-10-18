package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.CreateStudentDTO;
import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.StudentChecking;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentServiceInterface {

    public StudentChecking createStudent(CreateStudentDTO studentChecking);

}
