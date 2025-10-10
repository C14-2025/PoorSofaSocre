package org.example.futebol.pessoa_fisica;

import org.example.futebol.pessoa_juridica.Equipe;
import org.example.futebol.interfaces.Aposentavel;
import org.example.futebol.interfaces.Contratavel;
import org.example.futebol.interfaces.Transferivel;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa implements Contratavel, Transferivel, Aposentavel {

    private final String nacionalidade;
    private Equipe equipe;
    private static List<Tecnico> lista_tecnicos = new ArrayList<Tecnico>();

    public Tecnico(String nome, int idade, String cpf, String nacionalidade) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
        lista_tecnicos.add(this);
    }

    @Override
    public void mostrarInformacoes(){
        System.out.println("\nNome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nacionalidade: " + nacionalidade);
        try {
            System.out.println("Equipe: " + equipe.getNome());
        } catch (NullPointerException e) {
            System.out.println("O técnico está livre no mercado!");
        }
    }

    @Override
    public void contratar(Equipe equipe) {
        this.equipe = equipe;
        equipe.adcionaTecnico(this);
    }

    @Override
    public void transferir(Equipe equipeDestino) {
        this.equipe = equipeDestino;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() { return idade; }

    public String getCpf() { return cpf; }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public static List<Tecnico> getListaTecnicos() {
        return lista_tecnicos;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
