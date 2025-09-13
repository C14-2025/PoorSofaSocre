package org.example.futebol.pessoa_fisica;

import org.example.futebol.pessoa_juridica.Equipe;

public class Torcedor extends Pessoa {

    private final Equipe equipe;

    public Torcedor(String nome, int idade, String cpf, Equipe equipe) {
        super(nome, idade, cpf);
        this.equipe = equipe;
        equipe.adicionaTorcedor();
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Time do coração: " + equipe.getNome());
    }

}
