package visao.impl;

import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaEspecial;
import dominio.ContaPoupanca;
import dominio.ContaSimples;
import dominio.Usuario;
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
        Conta conta = contaViewFactory.create(enumType).criarConta(usuario);
        System.out.printf("A conta criada foi: %s , Numero: %d\n", conta.getTipoConta(), conta.getNumeroConta());
        return conta;
    }

    @Override
    public void depositar(Usuario usuario, BigDecimal valor, Conta conta) {
        if (conta instanceof ContaEspecial) {
            contaViewFactory.create(ContaEnum.ESPECIAL).depositar(valor, conta);
            System.out.printf("O valor depositado foi de R$ %.2f\nO seu novo saldo é de R$ %.2f\n", valor, ((ContaEspecial) conta).getSaldo());
        } else if (conta instanceof ContaPoupanca) {
            contaViewFactory.create(ContaEnum.POUPANCA).depositar(valor, conta);
            System.out.printf("O valor depositado foi de R$ %.2f\nO seu novo saldo é de R$ %.2f\n", valor, ((ContaPoupanca) conta).getSaldo());
        } else if (conta instanceof ContaSimples) {
            contaViewFactory.create(ContaEnum.SIMPLES).depositar(valor, conta);
            System.out.printf("O valor depositado foi de R$ %.2f\nO seu novo saldo é de R$ %.2f\n", valor, ((ContaSimples) conta).getSaldo());
        }
    }


    @Override
    public void saque(Usuario usuario, BigDecimal valor, Conta conta) {
        if (conta instanceof ContaEspecial) {
            contaViewFactory.create(ContaEnum.ESPECIAL).sacar(valor, conta);
            System.out.printf("O valor sacado foi de R$ %.2f\nO seu novo saldo é de R$ %.2f\n", valor, ((ContaEspecial) conta).getSaldo());
        } else if (conta instanceof ContaPoupanca) {
            contaViewFactory.create(ContaEnum.POUPANCA).sacar(valor, conta);
            System.out.printf("O valor sacado foi de R$ %.2f\nO seu novo saldo é de R$ %.2f\n", valor, ((ContaPoupanca) conta).getSaldo());
        } else if (conta instanceof ContaSimples) {
            contaViewFactory.create(ContaEnum.SIMPLES).sacar(valor, conta);
            System.out.printf("O valor sacado foi de R$ %.2f\nO seu novo saldo é de R$ %.2f\n", valor, ((ContaSimples) conta).getSaldo());
        }
    }

    @Override
    public void saldo(Usuario usuario, Conta conta) {
        BigDecimal saldo;
        if (conta instanceof ContaEspecial) {
            saldo = contaViewFactory.create(ContaEnum.ESPECIAL).saldo(conta);
            BigDecimal limite = new BigDecimal(200);
            if (saldo.compareTo(limite) > 0) {
                System.out.printf("O saldo da conta %d é R$ %.2f e o limite é R$ %.2f\n", conta.getNumeroConta(), saldo.subtract(limite), limite);
            } else {
                System.out.printf("O saldo da conta %d é R$ 0,00 e o limite é R$ %.2f\n", conta.getNumeroConta(), limite);
            }
        } else if (conta instanceof ContaPoupanca) {
            saldo = contaViewFactory.create(ContaEnum.POUPANCA).saldo(conta);
            System.out.printf("O saldo da conta %d é R$ %.2f\n", conta.getNumeroConta(), saldo);
        } else if (conta instanceof ContaSimples) {
            saldo = contaViewFactory.create(ContaEnum.SIMPLES).saldo(conta);
            System.out.printf("O saldo da conta %d é R$ %.2f\n", conta.getNumeroConta(), saldo);
        }
    }
}

