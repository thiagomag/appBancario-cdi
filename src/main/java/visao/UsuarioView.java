package visao;

import dominio.Usuario;

import java.util.List;
import java.util.Scanner;

public interface UsuarioView {
    Usuario CriarUsuario(Scanner input);
    Usuario getUsuario(Scanner input);
    List<Usuario> retornarLista();
}
