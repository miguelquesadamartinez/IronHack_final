package lab.miguel.code.entity;

import javax.persistence.Entity;

@Entity
public class Savings extends Account{

    private double interestRate;

    private double minimumBalance;

