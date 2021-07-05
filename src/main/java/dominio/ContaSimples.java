package dominio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContaSimples extends Conta {

    protected int variacao = 1;
    protected BigDecimal saldo = new BigDecimal(0);
    protected String tipoConta = String.valueOf(ContaEnum.SIMPLES);


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