package servico.impl;

import annotation.TipoConta;
import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaPoupanca;
import dominio.Usuario;
import servico.ContaService;

@TipoConta(value = ContaEnum.POUPANCA)
public class ContaPoupancaImpl implements ContaService {

    @Override
    public Conta criarConta(Usuario usuario) {
        var conta = new ContaPoupanca();
        usuario.setContas(conta);
        return conta;
    }
}
