package dominio;

import lombok.Data;

import java.util.Random;

@Data
public abstract class Conta {
    protected String agencia;
    protected int numeroConta;
    protected String tipoConta;

    public Conta() {
        Random numero = new Random();
        this.agencia = "0001-9";
        this.numeroConta = 1 + numero.nextInt(9999);
    }

    @Override
    public String toString() {
        return agencia + ";" +
                numeroConta + ";";
    }
}
