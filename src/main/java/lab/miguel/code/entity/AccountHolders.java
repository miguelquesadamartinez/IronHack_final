package lab.miguel.code.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class AccountHolders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String dateOFBirth;

    @ManyToOne
    @JoinColumn(name = "primary_address_id")
    private Address primaryAddress;
    @ManyToOne
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    public AccountHolders() {
    }

    public AccountHolders(Long id, String name, String dateOFBirth, Address primaryAddress, Address mailingAddress) {
        this.id = id;
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

}
