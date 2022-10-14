package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Savings extends Account {

    private static double DEFAULT_INTEREST = 0.0025;
    private static double MAX_BALANCE = 100;
    private static double MIN_BALANCE = 100;

    private double interestRate;

    private double minimumBalance;

    public Savings() {
        this.interestRate = DEFAULT_INTEREST;
        this.minimumBalance = MIN_BALANCE;
    }

    public Savings(Long id, double balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, double penaltyFee, LocalDate creationDate, Status status, String secretKey, double interestRate, double minimumBalance) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        if (interestRate <= DEFAULT_INTEREST ) {
            this.interestRate = interestRate;
        } else {
            this.interestRate = DEFAULT_INTEREST;
        }

        if (minimumBalance >= MIN_BALANCE && minimumBalance <= MAX_BALANCE) {
            this.minimumBalance = minimumBalance;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public static double getDefaultInterest() {
        return DEFAULT_INTEREST;
    }

    public static void setDefaultInterest(double defaultInterest) {
        DEFAULT_INTEREST = defaultInterest;
    }

    public static double getMaxBalance() {
        return MAX_BALANCE;
    }

    public static void setMaxBalance(double maxBalance) {
        MAX_BALANCE = maxBalance;
    }

    public static double getMinBalance() {
        return MIN_BALANCE;
    }

    public static void setMinBalance(double minBalance) {
        MIN_BALANCE = minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}