package org.example.futebol.campeonatos;

import org.example.futebol.pessoa_juridica.Equipe;
import org.example.futebol.pessoa_juridica.Federacao;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {

    private int idCampeonato;
    private String nome;
    private String local;
    private int premio;
    private Federacao federacao;
    private List<Equipe> lista_equipes = new ArrayList<>();
    private static List<Campeonato> lista_campeonatos = new ArrayList<>();

    public Campeonato(String nome, String local, int premio, int idCampeonato) {
        this.nome = nome;
        this.local = local;
        this.premio = premio;
        this.idCampeonato = idCampeonato;
        lista_campeonatos.add(this);
    }

    public void adicionarFederacao(Federacao federacao) {
        this.federacao = federacao;
        federacao.adicionarCampeonato(this);
    }

    public void adicionarEquipe(Equipe equipe) {
        lista_equipes.add(equipe);
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Prémio: " + premio);
        System.out.println("Local: " + local);
        try {
            System.out.println("Federação: " + federacao.getNome());
        } catch (NullPointerException e) {
            System.out.println("Não foi adicionado a uma federação!");
        }
        System.out.println("Lista de equipes: ");
        for(Equipe equipe : lista_equipes) {
            System.out.println(equipe.getNome());
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public int getPremio() {
        return premio;
    }

    public String getLocal() {
        return local;
    }

    public Federacao getFederacao() {
        return federacao;
    }

    public List<Equipe> getLista_equipes() {
        return lista_equipes;
    }

    public static List<Campeonato> getListaCampeonato() {
        return lista_campeonatos;
    }
}
