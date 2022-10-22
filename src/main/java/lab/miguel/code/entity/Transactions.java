package lab.miguel.code.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long idAccount;
    private LocalDate fecha;
    private Money amount;

    public Transactions(Long idAccount, LocalDate fecha, Money amount) {
        this.idAccount = idAccount;
        this.fecha = fecha;
        this.amount = amount;
    }

    public Transactions() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
