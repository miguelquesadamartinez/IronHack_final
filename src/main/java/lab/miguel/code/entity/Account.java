package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double balance;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolders PrimaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolders SecondaryOwner;
    private double penaltyFee;
    private LocalDate creationDate;
    private Status status;

    private String secretKey;

    public Account() {
    }

    public Account(Long id, double balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, double penaltyFee, LocalDate creationDate, Status status, String secretKey) {
        this.id = id;
        this.balance = balance;
        PrimaryOwner = primaryOwner;
        SecondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(double penaltyFee) {
        this.penaltyFee = penaltyFee;
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

    public AccountHolders getSecondaryOwner() {
        return SecondaryOwner;
    }

    public void setSecondaryOwner(AccountHolders SecondaryOwner) {
        this.SecondaryOwner = SecondaryOwner;
    }

    public AccountHolders getPrimaryOwner() {
        return PrimaryOwner;
    }

    public void setPrimaryOwner(AccountHolders PrimaryOwner) {
        this.PrimaryOwner = PrimaryOwner;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
