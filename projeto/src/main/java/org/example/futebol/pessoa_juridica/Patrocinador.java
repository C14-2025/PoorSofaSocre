package org.example.futebol.pessoa_juridica;

import org.example.futebol.interfaces.Contratavel;

import java.util.ArrayList;
import java.util.List;

public class Patrocinador extends Empresa implements Contratavel {

    private List<Equipe> lista_equipes = new ArrayList<>();
    private List<Integer> valor_equipes = new ArrayList<>();
    private static List<Patrocinador> lista_patrocinador = new ArrayList<>();

    @Override
    public void contratar(Equipe equipe, int valor) {
        equipe.adicionarPatrocinador(this, valor);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Lista de equipes patrocinadas: ");
        for (int i = 0; i < valor_equipes.size(); i++) {
            System.out.println("Nome: " + lista_equipes.get(i).getNome());
            System.out.println("Valor: " + valor_equipes.get(i));
        }
    }

    public Patrocinador(String nome, String cnpj) {
        super(nome,cnpj);
        lista_patrocinador.add(this);
    }

    public void adicionarEquipe(Equipe equipe, int valor) {
        lista_equipes.add(equipe);
        valor_equipes.add(valor);
    }

    public void setLista_Equipe(List<Equipe> lista_Equipe) {
        this.lista_equipes = lista_Equipe;
    }

    public static List<Patrocinador> getListaPatrocinador() {
        return lista_patrocinador;
    }
}
