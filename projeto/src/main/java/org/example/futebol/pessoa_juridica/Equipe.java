package org.example.futebol.pessoa_juridica;

import org.example.futebol.campeonatos.Campeonato;
import org.example.futebol.pessoa_fisica.Jogador;
import org.example.futebol.pessoa_fisica.Tecnico;

import java.util.ArrayList;
import java.util.List;

public class Equipe extends Empresa {

    private int fundacao;
    private String sede;
    private List<Jogador> lista_jogadores = new ArrayList<>();
    private Tecnico tecnico;
    private List<Patrocinador> lista_patrocinadores = new ArrayList<>();
    private List<Integer> valor_patrocinadores = new ArrayList<>();
    private List<Campeonato> lista_campeonatos = new ArrayList<>();
    private static List<Equipe> lista_equipes = new ArrayList<>();
    private static int quantidade_torcedores = 0;

    public Equipe(String nome,String cnpj, int fundacao, String sede) {
        super(nome,cnpj);
        this.fundacao = fundacao;
        this.sede = sede;
        lista_equipes.add(this);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("\nNome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Fundação: " + fundacao);
        System.out.println("Sede: " + sede);
        try {
            System.out.println("Técnico: " + tecnico.getNome());
        } catch (NullPointerException e) {
            System.out.println("A equipe está sem técnico!");
        }
        System.out.println("Lista de jogadores: ");
        for (Jogador jogador : lista_jogadores) {
            System.out.println(jogador.getNome());
        }
        System.out.println("Lista de patrocinadores: ");
        for (int i = 0; i < valor_patrocinadores.size(); i++) {
            System.out.println("Nome: " + lista_patrocinadores.get(i).getNome());
            System.out.println("Valor: " + valor_patrocinadores.get(i));
        }
        System.out.println("Lista de campeonatos: ");
        for(Campeonato campeonato : lista_campeonatos) {
            System.out.println(campeonato.getNome());
        }
        System.out.println("Número de torcedores: " + quantidade_torcedores);
    }

    public void transferirTecnico(Tecnico tecnico, Equipe equipe_destino) {
        this.tecnico = null;
        if (equipe_destino.getTecnico() != null) {
            equipe_destino.getTecnico().setEquipe(null);
        }
        tecnico.transferir(equipe_destino);
        equipe_destino.tecnico = tecnico;
    }

    public void transferirJogador(Jogador jogador, Equipe equipe_destino) {
        this.lista_jogadores.remove(jogador);
        equipe_destino.lista_jogadores.add(jogador);
        jogador.transferir(equipe_destino);
    }

    public void adcionaJogador(Jogador jogador) {
        lista_jogadores.add(jogador);
    }

    public void adcionaTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void adicionarPatrocinador(Patrocinador patrocinador, int valor) {
        lista_patrocinadores.add(patrocinador);
        valor_patrocinadores.add(valor);
        patrocinador.adicionarEquipe(this, valor);
    }

    public void adicionarCampeonato(Campeonato campeonato) {
        lista_campeonatos.add(campeonato);
        campeonato.adicionarEquipe(this);
    }

    public static List<Equipe> getListaEquipes() {
        return lista_equipes;
    }

    public int getFundacao() {
        return fundacao;
    }

    public String getSede() {
        return sede;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public List<Integer> getValor_patrocinadores() {
        return valor_patrocinadores;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void adicionaTorcedor() {
        quantidade_torcedores += 1;
    }

    public List<Jogador> getLista_jogadores() {
        return lista_jogadores;
    }
}
