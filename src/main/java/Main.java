import aplicacao.Aplicacao;
import exceptions.IdadeNaoPermitidaException;
import exceptions.SaldoInsuficienteException;
import exceptions.UsuarioNaoExisteException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            final WeldContainer container = new Weld().initialize();
            final Aplicacao aplicacao = container.select(Aplicacao.class).get();
            var input = new Scanner(System.in);
            aplicacao.getUsuarioView().menu(aplicacao, input);
        } catch (NullPointerException | UsuarioNaoExisteException e) {
            System.err.println("Usuário não existe");
        } catch (InputMismatchException e) {
            System.err.println("Informe um valor válido");
        } catch (SaldoInsuficienteException | IdadeNaoPermitidaException e){
            System.err.println(e.getMessage());
        }
    }
}