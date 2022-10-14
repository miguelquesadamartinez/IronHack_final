package lab.miguel.code.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AccountHolders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private LocalDate dateOFBirth;

    @ManyToOne
    @JoinColumn(name = "primary_address_id")
    @JsonIgnore
    private Address primaryAddress;
    @ManyToOne
    @JoinColumn(name = "mailing_address_id")
    @JsonIgnore
    private Address mailingAddress;

    public AccountHolders() {
    }

    public AccountHolders(Long id, String name, LocalDate dateOFBirth, Address primaryAddress, Address mailingAddress) {
        this.id = id;
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOFBirth() {
        return dateOFBirth;
    }

    public void setDateOFBirth(LocalDate dateOFBirth) {
        this.dateOFBirth = dateOFBirth;
    }
}
