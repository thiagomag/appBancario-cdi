package aplicacao;

import visao.ContaView;
import visao.UsuarioView;

import javax.inject.Inject;

public class Aplicacao {

    @Inject
    private UsuarioView usuarioView;

    @Inject
    private ContaView contaView;

    public ContaView getContaView() {
        return contaView;
    }

    public UsuarioView getUsuarioView() {
        return usuarioView;
    }
}
