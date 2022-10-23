package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Creditcard extends Account {

    private double creditLimit;
    private double interestRate;

    public Creditcard() {
        this.creditLimit = 100;
        this.interestRate = 0.2;
    }

    public Creditcard(Money balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction, double creditLimit, double interestRate) {
        super(balance, primaryOwner, secondaryOwner, creationDate, status, secretKey, dateLastAction);

        if ( interestRate >= 0.1 && interestRate <= 0.2 ) {
            this.interestRate = interestRate;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);


        if (creditLimit >= 100 && creditLimit <= 100000) {
            this.creditLimit = creditLimit;
        } else {
            throw new ResponseStatusException(HttpStatus.LENGTH_REQUIRED);
        };
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {

        if (creditLimit >= 100 && creditLimit <= 100000) {
            this.creditLimit = creditLimit;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        };
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate <= 0.2 && interestRate > 0.1 ) {
            this.interestRate = interestRate;
        } else if (interestRate < 0.1 || interestRate > 0.2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
