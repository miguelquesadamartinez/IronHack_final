package lab.miguel.code.entity;

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

    private Address primaryAddress;
    private Address mailingAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
