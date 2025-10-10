package br.inatel.futebol.pessoa_juridica;

import br.inatel.futebol.interfaces.Contratavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patrocinador extends Empresa implements Contratavel {

    private Map<Equipe, Integer> listaEquipes = new HashMap<>();
    private static List<Patrocinador> lista_patrocinador = new ArrayList<>();

    @Override
    public void contratar(Equipe equipe, int valor) {
        equipe.adicionarPatrocinador(this, valor);
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Lista de equipes patrocinadas: ");
        listaEquipes.forEach((chave, valor) -> {
            System.out.println("nome: " + chave.getNome());
            System.out.println("valor: " + valor);
        });
    }

    public Patrocinador(String nome, String cnpj) {
        super(nome,cnpj);
        lista_patrocinador.add(this);
    }

    public void adicionarEquipe(Equipe equipe, int valor) {
        listaEquipes.put(equipe, valor);
    }

    public static List<Patrocinador> getListaPatrocinador() {
        return lista_patrocinador;
    }
}