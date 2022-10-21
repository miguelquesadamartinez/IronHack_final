package lab.miguel.code.entity;

import lab.miguel.code.controllers.DTOs.ThirdPartyDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ThirdParty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String hashedKey;
    private String name;

    private Money balance;

    public void increaseAmount(double amount){
        this.balance.increaseAmount(new Money(BigDecimal.valueOf(amount)));
    }
    public void decreaseAmoutn(double amount){
        this.balance.decreaseAmount(new Money(BigDecimal.valueOf(amount)));
    }

    public ThirdParty() {
    }

    public ThirdParty(String hashedKey, String name, Money balance) {
        this.hashedKey = hashedKey;
        this.name = name;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
