package pessoa_juridicaTeste;

import org.example.futebol.campeonatos.Campeonato;
import org.example.futebol.pessoa_fisica.Arbitro;
import org.example.futebol.pessoa_juridica.Federacao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FederacaoTest {

    @Test
    void deveAdicionarArbitroECampeonato() {
        Federacao fed = new Federacao("CBF", "11222333000100");
        Arbitro arbitro = new Arbitro("Daronco", 40, "12345678900");
        Campeonato camp = new Campeonato("Copa do Brasil", "Brasil", 2000000, 2);

        fed.adicionarArbitro(arbitro);
        fed.adicionarCampeonato(camp);

        assertTrue(Federacao.getListaFederacao().contains(fed));
    }
}
