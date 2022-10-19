package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private static double PENALTY_FEE = 40;

    private Money balance;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolders primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolders secondaryOwner;

    //private double penaltyFee;

    private LocalDate creationDate;
    private Status status;

    private String secretKey;

    private LocalDate dateLastAction;

    public Account() {
    }

    public static Long getAge(String fecha){

        LocalDate start = LocalDate.of(1996, 2, 29);
        LocalDate end = LocalDate.now();
        Long years = ChronoUnit.YEARS.between(start, end);

        return years;
    }

    public static boolean makeAYear(){
        LocalDate currentDate = LocalDate.now();
        LocalDate pastDate = currentDate.minusYears(1);

        if (currentDate.isEqual(pastDate))
            return true;
        else
            return false;
    }

    public Account(Money balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, LocalDate creationDate, Status status, String secretKey, LocalDate dateLastAction) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
        this.dateLastAction = dateLastAction;
    }

    public double getDoubleBalance(){

        return this.balance.getAmount().longValue();

    }

    public void increaseAmount(double amount){
        this.balance.increaseAmount(new Money(BigDecimal.valueOf(amount)));
    }
    public void decreaseAmoutn(double amount){
        this.balance.decreaseAmount(new Money(BigDecimal.valueOf(amount)));
    }


}
