package visao.impl;

import dominio.Usuario;
import servico.UsuarioService;
import visao.UsuarioView;

import javax.inject.Inject;
import java.io.IOException;
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
        return usuarioService.criarUsuario(nome, idade);
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

}