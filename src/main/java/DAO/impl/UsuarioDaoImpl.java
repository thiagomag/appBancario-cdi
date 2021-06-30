package DAO.impl;

 import DAO.UsuarioDao;
import dominio.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {
    List<Usuario> usuarioList = new ArrayList<>();

    @Override
    public void escreverArquivo(Usuario usuario) {
        usuarioList.add(usuario);
        try {
            FileWriter myWriter = new FileWriter("filename.csv");
            myWriter.write(String.valueOf(usuarioList));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> lerArquivo() {
        return usuarioList;
    }
}
