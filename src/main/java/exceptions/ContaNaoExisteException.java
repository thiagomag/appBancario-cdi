package exceptions;

import dominio.Conta;
import dominio.Usuario;

public class ContaNaoExisteException extends RuntimeException {

    public ContaNaoExisteException(Usuario usuario, Conta conta) {
        super("A conta " + conta + "não pertence ao usuário " + usuario);
    }
}
