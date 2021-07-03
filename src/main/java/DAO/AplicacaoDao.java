package DAO;

import dominio.Usuario;

import java.io.IOException;
import java.util.List;

public interface AplicacaoDao {
    void escreverArquivo(Usuario usuario) throws IOException;
    List<Usuario> lerArquivo(String usuario) throws IOException;
}
