package org.example.futebol.interfaces;

import org.example.futebol.pessoa_juridica.Equipe;

public interface Transferivel {

    default void transferir(Equipe equipe_destino) {

    }
}
