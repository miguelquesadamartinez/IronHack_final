package lab.miguel.code.repositories;

import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {



}
