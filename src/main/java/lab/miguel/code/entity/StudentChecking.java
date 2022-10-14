package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class StudentChecking extends Account{

    public StudentChecking() {
    }

    public StudentChecking(Long id, double balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, double penaltyFee, LocalDate creationDate, Status status, String secretKey) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
    }
}
