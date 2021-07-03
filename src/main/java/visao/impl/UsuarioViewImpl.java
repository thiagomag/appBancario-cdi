package visao.impl;

import aplicacao.Aplicacao;
import dominio.Conta;
import dominio.Usuario;
import servico.UsuarioService;
import visao.UsuarioView;

import javax.inject.Inject;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Inject
    UsuarioService usuarioService;

    @Override
    public Usuario CriarUsuario(Scanner input) {
        System.out.println("Bem vindo ao sistema de cadastro de usuário");
        System.out.println("Informe o nome do novo usuário");
        input.nextLine();
        String nome = input.nextLine();
        System.out.println("Informa a idade do usuário");
        int idade = input.nextInt();
        Usuario usuario = usuarioService.criarUsuario(nome, idade);
        System.out.printf("O usuario criado foi: %s , %d anos\n", usuario.getNome(), usuario.getIdade());
        return usuario;
    }

    @Override
    public Usuario getUsuario(Scanner input) throws IOException {
        input.nextLine();
        String nome = input.nextLine();
        return usuarioService.consultarUsuario(nome);
    }

    @Override
    public void escreverArquivo(Usuario usuario) throws IOException {
        usuarioService.escreverArquivo(usuario);
    }

    @Override
    public void menu(Aplicacao aplicacao, Scanner input) throws IOException, InterruptedException {
        boolean continua = true;
        System.out.println("----------------------------------\n" +
                "Bem vindo ao sistema do Banco XPTO\n" +
                "----------------------------------");
        Usuario usuario;
        Conta conta;
        BigDecimal valor;
        while (continua) {
            switch (aplicacao.getUsuarioView().opcMenu(input)) {
                case 1:
                    usuario = aplicacao.getUsuarioView().CriarUsuario(input);
                    aplicacao.getContaView().criaConta(usuario);
                    aplicacao.getUsuarioView().escreverArquivo(usuario);
                    Thread.sleep(3000);
                    break;
                case 2:
                    System.out.println("Informe o usuário que a conta será criada.");
                    usuario = aplicacao.getUsuarioView().getUsuario(input);
                    aplicacao.getContaView().criaConta(usuario);
                    aplicacao.getUsuarioView().escreverArquivo(usuario);
                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.println("Informe o usuário da conta que receberá o depósito.");
                    usuario = aplicacao.getUsuarioView().getUsuario(input);
                    System.out.println("Escolha a conta para depositar.");
                    for (int i = 0; i < usuario.getContas().size(); i++) {
                        System.out.printf("%d - Conta: %d, Tipo da Conta: %s\n", i + 1, usuario.getContas().get(i).getNumeroConta(), usuario.getContas().get(i).getTipoConta());
                    }
                    int n = input.nextInt();
                    conta = usuario.getContas().get(n - 1);
                    System.out.println("Informe o valor a ser depositado.");
                    valor = input.nextBigDecimal();
                    aplicacao.getContaView().depositar(usuario, valor, conta);
                    aplicacao.getUsuarioView().escreverArquivo(usuario);
                    Thread.sleep(3000);
                    break;
                case 4:
                    System.out.println("Informe o usuário da conta que realizará o saque.");
                    usuario = aplicacao.getUsuarioView().getUsuario(input);
                    System.out.println("Escolha a conta para sacar.");
                    for (int i = 0; i < usuario.getContas().size(); i++) {
                        System.out.printf("%d - Conta: %d, Tipo da Conta: %s\n", i + 1, usuario.getContas().get(i).getNumeroConta(), usuario.getContas().get(i).getTipoConta());
                    }
                    int x = input.nextInt();
                    conta = usuario.getContas().get(x - 1);
                    System.out.println("Informe o valor a ser sacado.");
                    valor = input.nextBigDecimal();
                    aplicacao.getContaView().saque(usuario, valor, conta);
                    aplicacao.getUsuarioView().escreverArquivo(usuario);
                    Thread.sleep(3000);
                    break;
                case 5:
                    System.out.println("Informe o usuário da conta que quer consultar o saldo.");
                    usuario = aplicacao.getUsuarioView().getUsuario(input);
                    System.out.println("Escolha a conta para ver o saldo.");
                    for (int i = 0; i < usuario.getContas().size(); i++) {
                        System.out.printf("%d - Conta: %d, Tipo da Conta: %s\n", i + 1, usuario.getContas().get(i).getNumeroConta(), usuario.getContas().get(i).getTipoConta());
                    }
                    int y = input.nextInt();
                    conta = usuario.getContas().get(y - 1);
                    aplicacao.getContaView().saldo(usuario, conta);
                    aplicacao.getUsuarioView().escreverArquivo(usuario);
                    Thread.sleep(3000);
                    break;
                case 0:
                    continua = false;
                    break;
            }
        }
    }

    @Override
    public int opcMenu(Scanner input) {
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
        } while (opc < 0 || opc > 6);
        return opc;
    }
}