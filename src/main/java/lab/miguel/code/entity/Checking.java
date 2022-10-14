package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Checking extends Account{

    private double monthlyMaintenanceFee;
    private double minimumBalance;

    public Checking() {
    }

    public Checking(Long id, double balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, double penaltyFee, LocalDate creationDate, Status status, String secretKey, double monthlyMaintenanceFee, double minimumBalance) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.minimumBalance = minimumBalance;
    }
}
