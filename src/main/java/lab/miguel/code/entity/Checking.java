package lab.miguel.code.entity;

import javax.persistence.Entity;

@Entity
public class Checking extends Account{
    private double monthlyMaintenanceFee;
    private double minimumBalance;

}
