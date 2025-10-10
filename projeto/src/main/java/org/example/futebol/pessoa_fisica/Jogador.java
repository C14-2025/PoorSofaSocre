package org.example.futebol.pessoa_fisica;

import org.example.futebol.pessoa_juridica.Equipe;
import org.example.futebol.interfaces.Aposentavel;
import org.example.futebol.interfaces.Contratavel;
import org.example.futebol.interfaces.Transferivel;

import java.util.ArrayList;
import java.util.List;

public class Jogador extends Pessoa implements Contratavel, Transferivel, Aposentavel {

    private final String nacionalidade;
    private String posicao;
    private Equipe equipe;
    private static List<Jogador> lista_jogadores = new ArrayList<Jogador>();

    public Jogador(String nome, int idade, String cpf, String nacionalidade, String posicao) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
        lista_jogadores.add(this);
    }

    @Override
    public void contratar(Equipe equipeDestino){
        equipe.adcionaJogador(this);
        this.equipe = equipeDestino;
    }

    @Override
    public void transferir(Equipe equipe_destino) {
        this.equipe = equipe_destino;
    }

    @Override
    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Posição: " + posicao);
        try {
            System.out.println("Equipe: " + equipe.getNome());
        } catch (NullPointerException e) {
            System.out.println("O técnico está livre no mercado!");
        }
    }



    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public static List<Jogador> getListaJogadores(){
        return lista_jogadores;
    }

}
