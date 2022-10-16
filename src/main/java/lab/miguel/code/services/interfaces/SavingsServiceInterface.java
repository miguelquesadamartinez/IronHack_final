package lab.miguel.code.services.interfaces;

import lab.miguel.code.entity.Checking;
import lab.miguel.code.entity.Savings;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsServiceInterface {

    Savings createSavings(Savings savings);

}
