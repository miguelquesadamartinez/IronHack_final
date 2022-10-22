package lab.miguel.code.controllers.DTOs;

public class ThirdPartyDTO {

    private String hashedKey;
    private String name;
    private double amount;

    public ThirdPartyDTO() {
    }

    public ThirdPartyDTO(String hashedKey, String name, double amount) {
        this.hashedKey = hashedKey;
        this.name = name;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
