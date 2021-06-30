package visao.impl;

import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaEspecial;
import dominio.ContaPoupanca;
import dominio.ContaSimples;
import dominio.Usuario;
import exceptions.ContaNaoExisteException;
import factory.ContaViewFactory;
import visao.ContaView;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Scanner;


public class ContaViewImpl implements ContaView {

    @Inject
    private ContaViewFactory contaViewFactory;

    @Override
    public Conta criaConta(Usuario usuario) {
        Scanner input = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Escolha o tipo de conta que será aberta");
            System.out.println("1 - Conta Simples\n" +
                    "2 - Conta Especial\n" +
                    "3 - Conta Poupança");
            opc = input.nextInt();
        } while (opc < 1 || opc > 3);
        ContaEnum enumType = null;
        switch (opc) {
            case 1:
                enumType = ContaEnum.SIMPLES;
                break;
            case 2:
                enumType = ContaEnum.ESPECIAL;
                break;
            case 3:
                enumType = ContaEnum.POUPANCA;
                break;
        }
        return contaViewFactory.create(enumType).criarConta(usuario);
    }

    @Override
    public void depositar(Usuario usuario, BigDecimal valor, Conta conta) throws ContaNaoExisteException {
        for (int i = 0; i < usuario.getContas().size(); i++) {
            if (usuario.getContas().get(i).getNumeroConta() == conta.getNumeroConta()) {
                if (conta instanceof ContaEspecial) {
                    BigDecimal saldo = ((ContaEspecial) conta).getSaldo().add(valor);
                    ((ContaEspecial) conta).setSaldo(saldo);
                } else if (conta instanceof ContaPoupanca) {
                    BigDecimal saldo = ((ContaPoupanca) conta).getSaldo().add(valor);
                    ((ContaPoupanca) conta).setSaldo(saldo);
                } else if (conta instanceof ContaSimples) {
                    BigDecimal saldo = ((ContaSimples) conta).getSaldo().add(valor);
                    ((ContaSimples) conta).setSaldo(saldo);
                }
            } else {
                throw new ContaNaoExisteException(usuario, conta);
            }
        }
    }

    @Override
    public void saque(Usuario usuario, BigDecimal valor, Conta conta) {
        for (int i = 0; i < usuario.getContas().size(); i++) {
            if (usuario.getContas().get(i).getNumeroConta() == conta.getNumeroConta()) {
                if (conta instanceof ContaEspecial) {
                    BigDecimal saldo = ((ContaEspecial) conta).getSaldo().subtract(valor);
                    ((ContaEspecial) conta).setSaldo(saldo);
                } else if (conta instanceof ContaPoupanca) {
                    BigDecimal saldo = ((ContaPoupanca) conta).getSaldo().subtract(valor);
                    ((ContaPoupanca) conta).setSaldo(saldo);
                } else if (conta instanceof ContaSimples) {
                    BigDecimal saldo = ((ContaSimples) conta).getSaldo().subtract(valor);
                    ((ContaSimples) conta).setSaldo(saldo);
                }
            } else {
                throw new ContaNaoExisteException(usuario, conta);
            }
        }
    }

    @Override
    public BigDecimal saldo(Usuario usuario, Conta conta) {
        BigDecimal saldo = null;
        if (conta instanceof ContaEspecial) {
            ContaEspecial contaEspecial = (ContaEspecial) conta;
            saldo = contaEspecial.getSaldo();
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
            saldo = contaPoupanca.getSaldo();
        } else if (conta instanceof ContaSimples) {
            ContaSimples contaSimples = (ContaSimples) conta;
            saldo = contaSimples.getSaldo();
        }
        return saldo;
    }
}

