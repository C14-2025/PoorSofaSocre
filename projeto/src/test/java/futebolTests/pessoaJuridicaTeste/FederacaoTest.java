package futebolTests.pessoaJuridicaTeste;

import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_fisica.Arbitro;
import br.inatel.futebol.pessoa_juridica.Federacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class FederacaoTest {

    @Test
    void deveAdicionarArbitroECampeonato() {
        Federacao fed = new Federacao("CBF", "11222333000100");
        Arbitro arbitro = new Arbitro("Daronco", 40, "12345678900");
        Campeonato camp = new Campeonato("Copa do Brasil", "Brasil", 2000000, 2);

        fed.adicionarArbitro(arbitro);
        fed.adicionarCampeonato(camp);

        Assertions.assertTrue(Federacao.getListaFederacao().contains(fed));
    }



}
