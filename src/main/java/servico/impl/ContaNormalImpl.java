package servico.impl;

import annotation.TipoConta;
import dominio.Conta;
import dominio.ContaEnum;
import dominio.ContaSimples;
import dominio.Usuario;
import servico.ContaService;

@TipoConta(value = ContaEnum.SIMPLES)
public class ContaNormalImpl implements ContaService {

    @Override
    public Conta criarConta(Usuario usuario) {
        var conta = new ContaSimples();
        usuario.setContas(conta);
        return conta;
    }
}