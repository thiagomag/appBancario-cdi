package factory;

import annotation.TipoConta;
import dominio.ContaEnum;

import javax.enterprise.util.AnnotationLiteral;

public class ContaViewAnnotationLiteral extends AnnotationLiteral<TipoConta> implements TipoConta{

    private final ContaEnum contaEnum;

    public ContaViewAnnotationLiteral(ContaEnum contaEnum) {
        this.contaEnum = contaEnum;
    }

    @Override
    public ContaEnum value() {
        return contaEnum;
    }
}
