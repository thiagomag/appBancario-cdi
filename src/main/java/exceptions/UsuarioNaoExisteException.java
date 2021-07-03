package exceptions;

public class UsuarioNaoExisteException extends RuntimeException{

    public UsuarioNaoExisteException() {
        super("Usuário ou senha não existem");
    }
}
