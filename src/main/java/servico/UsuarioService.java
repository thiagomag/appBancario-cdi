package servico;

import dominio.Usuario;

import java.io.IOException;


public interface UsuarioService {
    Usuario criarUsuario(String nome, int idade);
    Usuario consultarUsuario(String nome) throws IOException;
    void escreverArquivo(Usuario usuario) throws IOException;
}
