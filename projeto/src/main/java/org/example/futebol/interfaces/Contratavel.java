package org.example.futebol.interfaces;


import org.example.futebol.pessoa_juridica.Equipe;
import org.example.futebol.pessoa_juridica.Federacao;

public interface Contratavel {

    default void contratar(Equipe equipe, int valor) {

    }

    default void contratar(Equipe equipe){

    }

    default void contratar(Federacao federacao){

    }
}
