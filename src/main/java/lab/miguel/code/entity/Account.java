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
    private AccountHolders PrimaryOwner;
    private AccountHolders SecondaryOwner;
    private double penaltyFee;
    private LocalDate creationDate;
    private Status status;

    private String secretKey;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
