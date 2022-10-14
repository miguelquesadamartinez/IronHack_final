package lab.miguel.code.entity;

import lab.miguel.code.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Checking extends Account{

    private double monthlyMaintenanceFee;
    private double minimumBalance;

    public Checking() {
    }

}
