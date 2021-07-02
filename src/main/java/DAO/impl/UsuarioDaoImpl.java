package DAO.impl;

import DAO.UsuarioDao;
import dominio.Conta;
import dominio.ContaEspecial;
import dominio.ContaPoupanca;
import dominio.ContaSimples;
import dominio.Usuario;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsuarioDaoImpl implements UsuarioDao {
    List<Usuario> usuarioList;
    List<Conta> contasList = new ArrayList<>();

    @Override
    public void escreverArquivo(Usuario usuario) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("usuario-" + usuario.getNome() + ".txt"));
        bw.write(String.valueOf(usuario));
        bw.flush();
        bw.close();
        escreverContaArquivo(usuario);
    }

    private void escreverContaArquivo(Usuario usuario) throws IOException {
        contasList = new ArrayList<>();
        contasList.addAll(usuario.getContas());
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("contas-" + usuario.getNome() + ".txt"));
        for (int i = 0; i < contasList.size(); i++) {
            if (i == contasList.size() - 1) {
                bw.write(String.valueOf(usuario.getContas().get(i).toString()));
            } else {
                bw.write(String.valueOf(usuario.getContas().get(i).toString()));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }


    @Override
    public List<Usuario> lerArquivo(String nome) throws IOException {
        Path path = Paths.get("usuario-" + nome + ".txt");
        try (Stream<String> stream = Files.lines(path)) {
            List<String> lines = stream.collect(Collectors.toUnmodifiableList());
            Usuario usuario = new Usuario();
            for (int i = 0; i < lines.size(); i += 3) {
                usuario.setNome(lines.get(i));
                usuario.setIdade(Integer.parseInt(lines.get(i + 1)));
            }
            for (Conta conta : lerContaArquivo(nome)){
                usuario.setContas(conta);
            }
            usuarioList = new ArrayList<>();
            usuarioList.add(usuario);
        }
        return usuarioList;
    }

    private List<Conta> lerContaArquivo(String nome) throws IOException {
        Path path = Paths.get("contas-" + nome + ".txt");
        try (Stream<String> stream = Files.lines(path)) {
            List<String> lines = stream.collect(Collectors.toUnmodifiableList());
            for (int j = 0; j < lines.size(); j += 4) {
                String tipoConta = lines.get(j);
                Conta conta = null;
                switch (tipoConta) {
                    case "ContaSimples": {
                        conta = new ContaSimples();
                        conta.setAgencia(lines.get(j + 1));
                        conta.setNumeroConta(Integer.parseInt(lines.get(j + 2)));
                        ((ContaSimples) conta).setVariacao(Integer.parseInt(lines.get(j + 3)));
                        ((ContaSimples) conta).setSaldo(new BigDecimal(lines.get(j + 4)));
                        break;
                    }
                    case "ContaEspecial": {
                        conta = new ContaEspecial();
                        conta.setAgencia(lines.get(j + 1));
                        conta.setNumeroConta(Integer.parseInt(lines.get(j + 2)));
                        ((ContaEspecial) conta).setVariacao(Integer.parseInt(lines.get(j + 3)));
                        ((ContaEspecial) conta).setSaldo(new BigDecimal(lines.get(j + 4)));
                        break;
                    }
                    case "ContaPoupanca": {
                        conta = new ContaPoupanca();
                        conta.setAgencia(lines.get(j + 1));
                        conta.setNumeroConta(Integer.parseInt(lines.get(j + 2)));
                        ((ContaPoupanca) conta).setVariacao(Integer.parseInt(lines.get(j + 3)));
                        ((ContaPoupanca) conta).setSaldo(new BigDecimal(lines.get(j + 4)));
                        break;
                    }
                } if(conta == null){
                    break;
                }
                contasList.add(conta);
            }
        }
        return contasList;
    }
}