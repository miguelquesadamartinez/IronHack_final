package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private static double PENALTY_FEE = 40;

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

}
