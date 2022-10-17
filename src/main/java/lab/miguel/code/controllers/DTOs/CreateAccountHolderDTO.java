package lab.miguel.code.controllers.DTOs;

public class CreateAccountHolderDTO {

    private String name;
    private String dateOFBirth;
    private int primaryAddress;
    private int mailingAddress;

    public CreateAccountHolderDTO(String name, String dateOFBirth, int primaryAddress, int mailingAddress) {
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
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

    public int getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(int primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public int getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(int mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
