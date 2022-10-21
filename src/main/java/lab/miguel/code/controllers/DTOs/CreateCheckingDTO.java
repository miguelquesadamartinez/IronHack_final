package lab.miguel.code.controllers.DTOs;

import lab.miguel.code.enums.Status;

import java.time.LocalDate;

public class CreateCheckingDTO {

    private Double balance;
    private Long primaryOwner;
    private Long secondaryOwner;
    private LocalDate creationDate;
    private Status status;
    private String secretKey;
    private LocalDate dateLastAction;

    /* Metodos de Checking */

    private double monthlyMaintenanceFee;
    private double minimumBalance;

    public CreateCheckingDTO(double balance, Long primaryOwner, Long secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction, double monthlyMaintenanceFee, double minimumBalance) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
        this.dateLastAction = dateLastAction;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.minimumBalance = minimumBalance;
        System.err.println("Constructor CreateCheckingDTO");
        System.err.println(this.primaryOwner);
    }

    public CreateCheckingDTO() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwner() {
        return this.primaryOwner;
    }

    public void setPrimaryOwner(Long primaryOwner) {
        primaryOwner = primaryOwner;
    }

    public Long getSecondaryOwner() {
        return this.secondaryOwner;
    }

    public void setSecondaryOwner(Long secondaryOwner) {
        secondaryOwner = secondaryOwner;
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

    public double getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(double monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
