package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.StudentControllerInterface;
import lab.miguel.code.entity.StudentChecking;
import lab.miguel.code.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentControllerInterface {

    @Autowired
    StudentService studentService;

    @PostMapping("/create-student")
    @ResponseStatus(HttpStatus.OK)
    public StudentChecking createStudent(StudentChecking checking) {
        return studentService.createStudent(checking);
    }
}
