package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    //private double penaltyFee;

    private LocalDate creationDate;
    private Status status;

    private String secretKey;

    private LocalDate dateLastAction;

    public Account() {
    }

    // TODO: Falta constructor

    public static boolean makeAyear(){
        LocalDate currentDate = LocalDate.now();
        LocalDate pastDate = currentDate.minusYears(1);

        if (currentDate.isEqual(pastDate))
            return true;
        else
            return false;
    }

}
