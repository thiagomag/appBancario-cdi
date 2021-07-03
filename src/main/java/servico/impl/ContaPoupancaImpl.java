package servico.impl;

import annotation.TipoConta;
import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaPoupanca;
import dominio.Usuario;
import exceptions.SaldoInsuficienteException;
import servico.ContaService;

import java.math.BigDecimal;

@TipoConta(value = ContaEnum.POUPANCA)
public class ContaPoupancaImpl implements ContaService {

    @Override
    public Conta criarConta(Usuario usuario) {
        var conta = new ContaPoupanca();
        conta.setSaldo(new BigDecimal(100));
        usuario.setContas(conta);
        return conta;
    }

    @Override
    public BigDecimal saldo(Conta conta) {
        return ((ContaPoupanca) conta).getSaldo();
    }

    @Override
    public void depositar(BigDecimal valor, Conta conta) {
        BigDecimal saldo = ((ContaPoupanca) conta).getSaldo().add(valor);
        ((ContaPoupanca) conta).setSaldo(saldo);
    }

    @Override
    public void sacar(BigDecimal valor, Conta conta) {
        if (valor.compareTo(((ContaPoupanca) conta).getSaldo()) < 0){
            BigDecimal taxa = ((ContaPoupanca) conta).getSaldo().multiply(BigDecimal.valueOf(0.0007));
            BigDecimal saldo = ((ContaPoupanca) conta).getSaldo().subtract(valor).subtract(taxa);
            ((ContaPoupanca) conta).setSaldo(saldo);
        } else {
            throw new SaldoInsuficienteException();
        }
    }
}
