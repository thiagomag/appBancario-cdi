package exceptions;

public class IdadeNaoPermitidaException extends RuntimeException {

    public IdadeNaoPermitidaException() {
        super("Idade não permitida para abrir a conta");
    }
}
