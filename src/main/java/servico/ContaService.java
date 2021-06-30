package servico;

import dominio.Conta;
import dominio.Usuario;

public interface ContaService {
    Conta criarConta(Usuario usuario);
}
