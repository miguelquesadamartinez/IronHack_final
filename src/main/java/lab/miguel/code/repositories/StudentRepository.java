package lab.miguel.code.repositories;

import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentChecking, Long> {



}
