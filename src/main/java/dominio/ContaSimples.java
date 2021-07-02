package dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContaSimples extends Conta {

    private int variacao = 1;
    private BigDecimal saldo = new BigDecimal(0);

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
        return "ContaSimples\n" +
                agencia + "\n" +
                numeroConta + "\n" +
                variacao + "\n" +
                saldo;
    }
}