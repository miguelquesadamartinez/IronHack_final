package lab.miguel.code.controllers.DTOs;

import lab.miguel.code.enums.Status;

import java.time.LocalDate;

public class CreateStudentDTO {

    private double balance;
    private Long primaryOwner;
    private Long secondaryOwner;
    private LocalDate creationDate;
    private Status status;
    private String secretKey;
    private LocalDate dateLastAction;

    /* Metodos de Savings */

    public CreateStudentDTO() {
    }

    public CreateStudentDTO(double balance, Long primaryOwner, Long secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
        this.dateLastAction = dateLastAction;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Long primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Long getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Long secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
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
}
