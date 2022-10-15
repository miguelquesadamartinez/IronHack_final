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
public class Savings extends Account {

    /*
    private static double DEFAULT_INTEREST = 0.0025;
    private static double MAX_BALANCE = 1000;
    private static double MIN_BALANCE = 100;
    */
    private double interestRate;

    private double minimumBalance;

    public Savings() {
        this.interestRate = 0.0025;
        this.minimumBalance = 1000;
    }

    public Savings(double balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction, double interestRate, double minimumBalance) {
        super(balance, primaryOwner, secondaryOwner, creationDate, status, secretKey, dateLastAction);
        if (interestRate <= 0.5 ) {
            this.interestRate = interestRate;
        } else {
            this.interestRate = 0.0025;
        }

        if (minimumBalance >= 100 && minimumBalance <= 1000) {
            this.minimumBalance = minimumBalance;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate <= 0.0025 ) {
            this.interestRate = interestRate;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //this.interestRate = interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        if (minimumBalance >= 100 && minimumBalance <= 1000) {
            this.minimumBalance = minimumBalance;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}