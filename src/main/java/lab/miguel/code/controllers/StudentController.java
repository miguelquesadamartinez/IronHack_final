package lab.miguel.code.controllers;

import lab.miguel.code.controllers.DTOs.CreateStudentDTO;
import lab.miguel.code.controllers.interfaces.StudentControllerInterface;
import lab.miguel.code.entity.StudentChecking;
import lab.miguel.code.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController implements StudentControllerInterface {

    @Autowired
    StudentService studentService;

    @PostMapping("/create-student")
    @ResponseStatus(HttpStatus.OK)
    public StudentChecking createStudent(@RequestBody CreateStudentDTO checking) {
        return studentService.createStudent(checking);
    }
}
