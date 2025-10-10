package br.inatel.futebol.interfaces;

import br.inatel.futebol.pessoa_juridica.Equipe;
import br.inatel.futebol.pessoa_juridica.Federacao;

public interface Contratavel {

    default void contratar(Equipe equipe, int valor) {

    }

    default void contratar(Equipe equipe){

    }

    default void contratar(Federacao federacao){

    }
}