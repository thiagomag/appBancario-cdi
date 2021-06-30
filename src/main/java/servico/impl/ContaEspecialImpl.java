package servico.impl;

import annotation.TipoConta;
import dominio.Conta;
import dominio.ContaEnum;

import dominio.ContaEspecial;
import dominio.Usuario;
import servico.ContaService;

@TipoConta(value = ContaEnum.ESPECIAL)
public class ContaEspecialImpl implements ContaService {

    @Override
    public Conta criarConta(Usuario usuario) {
        var conta = new ContaEspecial();
        usuario.setContas(conta);
        return conta;
    }
}
