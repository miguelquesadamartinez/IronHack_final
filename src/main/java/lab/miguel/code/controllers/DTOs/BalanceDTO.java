package lab.miguel.code.controllers.DTOs;

public class BalanceDTO {
    private double balance;

    public BalanceDTO(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
