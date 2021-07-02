package visao;

import dominio.Usuario;

import java.io.IOException;
import java.util.Scanner;

public interface UsuarioView {
    Usuario CriarUsuario(Scanner input);
    Usuario getUsuario(Scanner input) throws IOException;
    void escreverArquivo(Usuario usuario) throws IOException;
}
