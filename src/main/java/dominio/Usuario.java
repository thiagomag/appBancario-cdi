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
    private String senha;
    private int idade;
    private List<Conta> contas = new ArrayList<>();

    public Usuario(String nome, String senha, int idade){
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
    }

    public void setContas(Conta conta) {
        contas.add(conta);
    }

    @Override
    public String toString() {
        return nome + "\n" +
               senha + "\n" +
               idade;
    }
}
