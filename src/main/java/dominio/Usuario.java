package dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String nome;
    private int idade;
    private List<Conta> contas = new ArrayList<>();

    public Usuario(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public void setContas(Conta conta) {
        contas.add(conta);
    }
}
