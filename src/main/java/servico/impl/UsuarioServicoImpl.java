package servico.impl;

import DAO.AplicacaoDao;
import dominio.Usuario;
import exceptions.UsuarioNaoExisteException;
import lombok.Data;
import servico.UsuarioService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;


@Data
@Named
public class UsuarioServicoImpl implements UsuarioService {


    @Inject
    AplicacaoDao aplicacaoDao;

    @Override
    public Usuario criarUsuario(String nome, int idade) {
        return new Usuario(nome, idade);
    }

    @Override
    public Usuario consultarUsuario(String nome) throws IOException {
        for (Usuario usuario : aplicacaoDao.lerArquivo(nome)) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            } else {
                throw new UsuarioNaoExisteException();
            }
        }
        return null;
    }

    @Override
    public void escreverArquivo(Usuario usuario) throws IOException {
        aplicacaoDao.escreverArquivo(usuario);
    }
}
