package servico;

import dominio.Conta;
import dominio.Usuario;

import java.math.BigDecimal;

public interface ContaService {
    Conta criarConta(Usuario usuario);
    BigDecimal saldo(Conta conta);
    void depositar(BigDecimal valor, Conta conta);
    void sacar(BigDecimal valor, Conta conta);
}