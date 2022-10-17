package lab.miguel.code.controllers.DTOs;

import lab.miguel.code.entity.Address;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreateAccountHolderDTO {

    private String name;
    private String dateOFBirth;
    private Address primaryAddress;
    private Address mailingAddress;
}
