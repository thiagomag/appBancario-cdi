package servico;

import dominio.Usuario;

import java.util.List;


public interface UsuarioService {
    void criarUsuario(Usuario usuario);
    Usuario consultarUsuario(String nome);
    List<Usuario> retornarLista();
}
