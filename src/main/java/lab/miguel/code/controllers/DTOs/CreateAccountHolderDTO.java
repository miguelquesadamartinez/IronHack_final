package lab.miguel.code.controllers.DTOs;


import lab.miguel.code.entity.Address;

public class CreateAccountHolderDTO {

    private String name;
    private String dateOFBirth;
    private Long primaryAddress;
    private Long mailingAddress;

    public CreateAccountHolderDTO() {
    }

    public CreateAccountHolderDTO(String name, String dateOFBirth, Long primaryAddress, Long mailingAddress) {
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public CreateAccountHolderDTO(String name, String dateOFBirth, Long primaryAddress) {
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.primaryAddress = primaryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOFBirth() {
        return dateOFBirth;
    }

    public void setDateOFBirth(String dateOFBirth) {
        this.dateOFBirth = dateOFBirth;
    }

    public Long getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Long primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Long getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Long mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
