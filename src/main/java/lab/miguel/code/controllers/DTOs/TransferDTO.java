package lab.miguel.code.controllers.DTOs;

public class TransferDTO {
    private long idOrigin;
    private double amount;
    private long idHolderUno;
    private long idHolderDos;

    public TransferDTO() {
    }

    public TransferDTO(long idOrigin, double amount, long idHolderUno, long idHolderDos) {
        this.idOrigin = idOrigin;
        this.amount = amount;
        this.idHolderUno = idHolderUno;
        this.idHolderDos = idHolderDos;
    }

    public long getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(long idOrigin) {
        this.idOrigin = idOrigin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getIdHolderUno() {
        return idHolderUno;
    }

    public void setIdHolderUno(long idHolderUno) {
        this.idHolderUno = idHolderUno;
    }

    public long getIdHolderDos() {
        return idHolderDos;
    }

    public void setIdHolderDos(long idHolderDos) {
        this.idHolderDos = idHolderDos;
    }
}
