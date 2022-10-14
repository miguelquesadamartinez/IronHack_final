package lab.miguel.code.entity;

import javax.persistence.*;

@Entity
public class ThirdParty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String hashedKey;
    private String name;

    public ThirdParty(Long id, String hashedKey, String name) {
        this.id = id;
        this.hashedKey = hashedKey;
        this.name = name;
    }

    public ThirdParty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
