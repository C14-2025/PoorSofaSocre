package br.inatel.futebol.interfaces;

import br.inatel.futebol.pessoa_juridica.Equipe;

public interface Transferivel {

    default void transferir(Equipe equipe_destino) {

    }
}
