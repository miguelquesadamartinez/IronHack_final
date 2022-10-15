package lab.miguel.code.repositories;

import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Creditcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditcardRepository extends JpaRepository<Creditcard, Long> {



}
