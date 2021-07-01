package visao;

import dominio.Conta;
import dominio.Usuario;

import java.math.BigDecimal;

public interface ContaView {
    Conta criaConta(Usuario usuario);
    void depositar(Usuario usuario, BigDecimal valor, Conta conta);
    void saque(Usuario usuario, BigDecimal valor, Conta conta);
    void saldo(Usuario usuario, Conta conta);
}
