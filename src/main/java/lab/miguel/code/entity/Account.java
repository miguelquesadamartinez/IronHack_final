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
