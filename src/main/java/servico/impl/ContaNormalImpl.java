package servico.impl;

import annotation.TipoConta;
import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaSimples;
import dominio.Usuario;
import exceptions.IdadeNaoPermitidaException;
import exceptions.SaldoInsuficienteException;
import servico.ContaService;

import java.math.BigDecimal;

@TipoConta(value = ContaEnum.SIMPLES)
public class ContaNormalImpl implements ContaService {

    @Override
    public Conta criarConta(Usuario usuario) {
        if(usuario.getIdade() >= 12) {
            var conta = new ContaSimples();
            usuario.setContas(conta);
            return conta;
        } else {
            throw new IdadeNaoPermitidaException();
        }
    }

    @Override
    public BigDecimal saldo(Conta conta) {
        return ((ContaSimples) conta).getSaldo();
    }

    @Override
    public void depositar(BigDecimal valor, Conta conta) {
        BigDecimal saldo = ((ContaSimples) conta).getSaldo().add(valor);
        ((ContaSimples) conta).setSaldo(saldo);
    }

    @Override
    public void sacar(BigDecimal valor, Conta conta) {
        if (valor.compareTo(((ContaSimples) conta).getSaldo()) < 0) {
            BigDecimal saldo = ((ContaSimples) conta).getSaldo().subtract(valor);
            ((ContaSimples) conta).setSaldo(saldo);
        } else {
            throw new SaldoInsuficienteException();
        }
    }
}