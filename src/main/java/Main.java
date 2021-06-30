import exceptions.UsuarioNaoExisteException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final WeldContainer container = new Weld().initialize();
        final Aplicacao aplicacao = container.select(Aplicacao.class).get();
        var input = new Scanner(System.in);
        Menu(aplicacao, input);
    }

    private static void Menu(Aplicacao aplicacao, Scanner input) {
        boolean continua = true;
        while (continua){
            switch (opcMenu(input)){
                case 1:
                    var usuario = aplicacao.getUsuarioView().CriarUsuario(input);
                    aplicacao.getContaView().criaConta(usuario);
                    break;
                case 2:
                    System.out.println("Informe o usuário que a conta será criada.");
                    var usuario1 = aplicacao.getUsuarioView().getUsuario(input);
                    aplicacao.getContaView().criaConta(usuario1);
                    break;
                case 3:
                    System.out.println("Informe o usuário da conta que receberá o depósito.");
                    var usuario2 = aplicacao.getUsuarioView().getUsuario(input);
                    System.out.println("Escolha a conta para depositar.");
                    for(int i = 0; i < usuario2.getContas().size(); i++){
                        System.out.printf("%d - Conta: %d", i+1 , usuario2.getContas().get(i).getNumeroConta());
                    }
                    int n = input.nextInt();
                    var conta = usuario2.getContas().get(n-1);
                    System.out.println("Informe o valor a ser depositado.");
                    var valor = input.nextBigDecimal();
                    aplicacao.getContaView().depositar(usuario2, valor, conta);
                    break;
                case 4:
                    System.out.println("Informe o usuário da conta que realizará o saque.");
                    var usuario3 = aplicacao.getUsuarioView().getUsuario(input);
                    System.out.println("Escolha a conta para sacar.");
                    for(int i = 0; i < usuario3.getContas().size(); i++){
                        System.out.printf("%d - Conta: %d", i+1 , usuario3.getContas().get(i).getNumeroConta());
                    }
                    int x = input.nextInt();
                    var conta2 = usuario3.getContas().get(x-1);
                    System.out.println("Informe o valor a ser sacado.");
                    var valor2 = input.nextBigDecimal();
                    aplicacao.getContaView().saque(usuario3, valor2, conta2);
                    break;
                case 5:
                    System.out.println("Informe o usuário da conta que quer consultar o saldo.");
                    var usuario4 = aplicacao.getUsuarioView().getUsuario(input);
                    System.out.println("Escolha a conta para ver o saldo.");
                    for(int i = 0; i < usuario4.getContas().size(); i++){
                        System.out.printf("%d - Conta: %d\n", i+1 , usuario4.getContas().get(i).getNumeroConta());
                    }
                    int y = input.nextInt();
                    var conta3 = usuario4.getContas().get(y-1);
                    var saldo = aplicacao.getContaView().saldo(usuario4, conta3);
                    System.out.println("O saldo da conta " + conta3.getNumeroConta() + " é R$" + saldo);
                    break;
                case 0:
                    continua = false;
                    break;
            }
        }
    }

    private static int opcMenu(Scanner input) {
        System.out.println("----------------------------------\n" +
                "Bem vindo ao sistema do Banco XPTO\n" +
                "----------------------------------");
        int opc;
        do {

            System.out.println("Escolha a opção desejada\n" +
                    "1 - Cadastrar Usuário\n" +
                    "2 - Criar conta\n" +
                    "3 - Depositar\n" +
                    "4 - Sacar\n" +
                    "5 - Saldo\n" +
                    "0 - Sair");
            opc = input.nextInt();
        } while(opc < 0 || opc > 6);
        return opc;
    }
}