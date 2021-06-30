package exceptions;

public class UsuarioNaoExisteException extends RuntimeException{

    public UsuarioNaoExisteException() {
        super("Usuário não existe");
    }
}
