package org.example.futebol.pessoa_fisica;

import org.example.futebol.pessoa_juridica.Federacao;
import org.example.futebol.interfaces.Contratavel;

import java.util.ArrayList;
import java.util.List;

public class Arbitro extends Pessoa implements Contratavel {

    private Federacao federacao;
    private static List<Arbitro> lista_arbitros = new ArrayList<Arbitro>();

    public Arbitro(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
        lista_arbitros.add(this);
    }

    @Override
    public void contratar(Federacao federacao){
        this.federacao = federacao;
        federacao.adicionarArbitro(this);
    }

    @Override
    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        try {
            System.out.println("Federação: " + federacao.getNome());
        } catch (NullPointerException e) {
            System.out.println("Não foi adicionado a uma federação!");
        }
    }

    public Federacao getFederacao() {
        return federacao;
    }

    public static List<Arbitro> getListaArbitros() {
        return lista_arbitros;
    }

}