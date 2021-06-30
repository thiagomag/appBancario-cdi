package DAO;

import dominio.Usuario;

import java.util.List;

public interface UsuarioDao {
    void escreverArquivo(Usuario usuario);
    List<Usuario> lerArquivo();
}
