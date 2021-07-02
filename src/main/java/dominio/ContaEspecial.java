package dominio;

 import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContaEspecial extends Conta{

    private int variacao = 10;
    private BigDecimal saldo = new BigDecimal(200);

    @Override
    public int getNumeroConta() {
        return super.getNumeroConta();
    }

    @Override
    public String getAgencia() {
        return super.getAgencia();
    }

    @Override
    public String toString() {
        return "ContaEspecial\n" +
                agencia + "\n" +
                numeroConta + "\n" +
                variacao + "\n" +
                saldo;
    }
}