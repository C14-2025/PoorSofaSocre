package br.inatel.futebol.pessoa_juridica;


import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_fisica.Arbitro;

import java.util.ArrayList;
import java.util.List;

public class Federacao extends Empresa{

    private List<Arbitro> lista_arbitro = new ArrayList<>();
    private List<Campeonato> lista_campeonato = new ArrayList<>();
    private static List<Federacao> lista_federacao = new ArrayList<>();

    public Federacao(String nome, String cnpj) {
        super(nome,cnpj);
        lista_federacao.add(this);
    }

    public void adicionarArbitro(Arbitro arbitro) {
        lista_arbitro.add(arbitro);
    }

    public void adicionarCampeonato(Campeonato campeonato) {
        lista_campeonato.add(campeonato);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Lista de árbitros: ");
        for (Arbitro arbitro : lista_arbitro) {
            System.out.println(arbitro.getNome());
        }
        System.out.println("Lista de campeonatos: ");
        for(Campeonato campeonato : lista_campeonato){
            System.out.println(campeonato.getNome());
        }
    }

    public static List<Federacao> getListaFederacao() {
        return lista_federacao;
    }
}
