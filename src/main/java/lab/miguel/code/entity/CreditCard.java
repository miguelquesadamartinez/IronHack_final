package lab.miguel.code.entity;

import javax.persistence.Entity;

@Entity
public class CreditCard extends Account {

    private double creditLimit;

    private double interestRate;
}
