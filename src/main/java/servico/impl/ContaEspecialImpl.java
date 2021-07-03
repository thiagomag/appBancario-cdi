package servico.impl;

import annotation.TipoConta;
import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaEspecial;
import dominio.Usuario;
import exceptions.IdadeNaoPermitidaException;
import exceptions.SaldoInsuficienteException;
import servico.ContaService;

import java.math.BigDecimal;

@TipoConta(value = ContaEnum.ESPECIAL)
public class ContaEspecialImpl implements ContaService {

    @Override
    public Conta criarConta(Usuario usuario) {
        if(usuario.getIdade() >= 18) {
            var conta = new ContaEspecial();
            conta.setSaldo(new BigDecimal(600));
            usuario.setContas(conta);
            return conta;
        } else {
            throw new IdadeNaoPermitidaException();
        }
    }

    @Override
    public BigDecimal saldo(Conta conta) {
        return ((ContaEspecial) conta).getSaldo();
    }

    @Override
    public void depositar(BigDecimal valor, Conta conta) {
        BigDecimal saldo = ((ContaEspecial) conta).getSaldo().add(valor);
        ((ContaEspecial) conta).setSaldo(saldo);
    }

    @Override
    public void sacar(BigDecimal valor, Conta conta) {
        if (valor.compareTo(((ContaEspecial) conta).getSaldo()) < 0) {
            BigDecimal saldo = ((ContaEspecial) conta).getSaldo().subtract(valor);
            ((ContaEspecial) conta).setSaldo(saldo);
        } else {
            throw new SaldoInsuficienteException();
        }
    }
}