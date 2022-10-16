package lab.miguel.code.controllers.DTOs;

public class AccountIdDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountIdDTO(Long id) {
        this.id = id;
    }
}
