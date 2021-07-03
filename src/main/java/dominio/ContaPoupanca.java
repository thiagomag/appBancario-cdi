package dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Data
public class ContaPoupanca extends Conta {

    protected int variacao = 51;
    protected BigDecimal saldo = new BigDecimal(400);
    protected String tipoConta = "Conta Poupança";

    @Override
    public String getAgencia() {
        return super.getAgencia();
    }

    @Override
    public int getNumeroConta() {
        return super.getNumeroConta();
    }

    @Override
    public String toString() {
        return tipoConta + "\n" +
                agencia + "\n" +
                numeroConta + "\n" +
                variacao + "\n" +
                saldo;
    }
}