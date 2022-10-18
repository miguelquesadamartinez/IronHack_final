package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class StudentChecking extends Account{

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction) {
        super(balance, primaryOwner, secondaryOwner, creationDate, status, secretKey, dateLastAction);
    }

}
