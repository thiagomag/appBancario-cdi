package servico.impl;

import DAO.UsuarioDao;
import dominio.Usuario;
import exceptions.UsuarioNaoExisteException;
import lombok.Data;
import servico.UsuarioService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Data
@Named
public class UsuarioServicoImpl implements UsuarioService {


    @Inject
    UsuarioDao usuarioDao;

    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioDao.escreverArquivo(usuario);
    }

    @Override
    public Usuario consultarUsuario(String nome) {
        for (Usuario usuario : usuarioDao.lerArquivo()) {
            if (usuario.getNome().equals(nome)){
                return usuario;
            } else {
                throw new UsuarioNaoExisteException();
            }
        }
        return null;
    }

    @Override
    public List<Usuario> retornarLista() {
        return usuarioDao.lerArquivo();
    }
}
