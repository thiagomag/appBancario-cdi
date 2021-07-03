package servico;

import dominio.Usuario;

import java.io.IOException;


public interface UsuarioService {
    Usuario criarUsuario(String nome, String senha, int idade);
    Usuario consultarUsuario(String nome, String senha) throws IOException;
    void escreverArquivo(Usuario usuario) throws IOException;
}
