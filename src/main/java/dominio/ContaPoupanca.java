package dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContaPoupanca extends Conta {

    private int variacao = 51;
    private BigDecimal saldo = new BigDecimal(400);

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
        return "ContaPoupanca\n" +
                agencia + "\n" +
                numeroConta + "\n" +
                variacao + "\n" +
                saldo;
    }
}