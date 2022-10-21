package lab.miguel.code.controllers.DTOs;

public class ThirdPartyDTO {

    private String hashedKey;
    private String name;

    public ThirdPartyDTO() {
    }

    public ThirdPartyDTO(String hashedKey, String name) {
        this.hashedKey = hashedKey;
        this.name = name;
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
}
