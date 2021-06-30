package visao.impl;

import dominio.Usuario;
import servico.UsuarioService;
import visao.UsuarioView;

import javax.inject.Inject;
import java.util.List;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Inject
    UsuarioService usuarioService;

    @Override
    public Usuario CriarUsuario(Scanner input) {
        Usuario usuario = new Usuario();
        System.out.println("Bem vindo ao sistema de cadastro de usuário");
        System.out.println("Informe o nome do novo usuário");
        input.nextLine();
        usuario.setNome(input.nextLine());
        System.out.println("Informa a idade do usuário");
        usuario.setIdade(input.nextInt());
        usuarioService.criarUsuario(usuario);
        return usuario;
    }

    @Override
    public Usuario getUsuario(Scanner input) {
        input.nextLine();
        String nome = input.nextLine();
        return usuarioService.consultarUsuario(nome);
    }

    @Override
    public List<Usuario> retornarLista() {
        return usuarioService.retornarLista();
    }
}