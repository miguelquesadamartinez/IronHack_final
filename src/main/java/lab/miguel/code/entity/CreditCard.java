package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class CreditCard extends Account {

    private double creditLimit;
    private double interestRate;

    public CreditCard() {
        this.creditLimit = 100;
        this.interestRate = 0.2;
    }

    public CreditCard(Long id, double balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, double penaltyFee, LocalDate creationDate, Status status, String secretKey, double creditLimit, double interestRate) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        if (interestRate <= 0.2 && interestRate > 0.1 ) {
            this.interestRate = interestRate;
        } else if (interestRate < 0.1 || interestRate > 0.2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (creditLimit >= 100 && creditLimit <= 100000) {
            this.creditLimit = creditLimit;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        };
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
