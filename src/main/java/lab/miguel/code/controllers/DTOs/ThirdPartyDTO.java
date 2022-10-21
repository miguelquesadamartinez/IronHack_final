package lab.miguel.code.controllers.DTOs;

public class ThirdPartyDTO {

    private String hashedKey;
    private String name;
    private double balance;

    public ThirdPartyDTO() {
    }

    public ThirdPartyDTO(String hashedKey, String name, double balance) {
        this.hashedKey = hashedKey;
        this.name = name;
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
