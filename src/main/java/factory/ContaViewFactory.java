package factory;

import dominio.ContaEnum;
import servico.ContaService;
import visao.ContaView;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class ContaViewFactory {

    @Inject
    @Any
    private Instance<ContaService> contaService;

    public ContaService create(final ContaEnum contaEnum) {
        final ContaViewAnnotationLiteral literal = new ContaViewAnnotationLiteral(contaEnum);
        return this.contaService.select(literal).get();
    }
}
