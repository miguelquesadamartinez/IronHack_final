package lab.miguel.code.controllers.DTOs;

import lab.miguel.code.enums.Status;

import java.time.LocalDate;

public class CreateCreditCardDTO {


    private double balance;
    private Long PrimaryOwner;
    private Long SecondaryOwner;
    private LocalDate creationDate;
    private Status status;
    private String secretKey;
    private LocalDate dateLastAction;

    /* Metodos de CredirCard */

    private double creditLimit;
    private double interestRate;

    public CreateCreditCardDTO() {
    }

    public CreateCreditCardDTO(Long primaryOwner, Long secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction, double creditLimit, double interestRate) {
        PrimaryOwner = primaryOwner;
        SecondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
        this.dateLastAction = dateLastAction;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
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
