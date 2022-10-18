package lab.miguel.code.controllers.DTOs;

import lab.miguel.code.enums.Status;
import java.time.LocalDate;

public class CreateSavingsDTO {

    private double balance;
    private Long PrimaryOwner;
    private Long SecondaryOwner;
    private LocalDate creationDate;
    private Status status;
    private String secretKey;
    private LocalDate dateLastAction;

    /* Metodos de Savings */

    private double interestRate;
    private double minimumBalance;

    public CreateSavingsDTO(Long primaryOwner, Long secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction, double interestRate, double minimumBalance) {
        PrimaryOwner = primaryOwner;
        SecondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
        this.dateLastAction = dateLastAction;
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public Long getPrimaryOwner() {
        return PrimaryOwner;
    }

    public void setPrimaryOwner(Long primaryOwner) {
        PrimaryOwner = primaryOwner;
    }

    public Long getSecondaryOwner() {
        return SecondaryOwner;
    }

    public void setSecondaryOwner(Long secondaryOwner) {
        SecondaryOwner = secondaryOwner;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getDateLastAction() {
        return dateLastAction;
    }

    public void setDateLastAction(LocalDate dateLastAction) {
        this.dateLastAction = dateLastAction;
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
