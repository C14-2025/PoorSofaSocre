package FutebolTestes;

import org.example.futebol.campeonatos.Campeonato;
import org.example.futebol.pessoa_juridica.Equipe;
import org.example.futebol.pessoa_juridica.Federacao;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoTest {

    @Test
    void deveCriarCampeonatoEAdicionarNaListaEstatica() {
        Campeonato c = new Campeonato("Brasileirão", "Brasil", 1000000, 1);

        assertEquals("Brasileirão", c.getNome());
        assertEquals("Brasil", c.getLocal());
        assertEquals(1000000, c.getPremio());
        assertTrue(Campeonato.getListaCampeonato().contains(c));
    }

    @Test
    void deveAdicionarFederacaoAoCampeonato() {
        Campeonato c = new Campeonato("Libertadores", "América do Sul", 5000000, 2);
        Federacao f = new Federacao("CONMEBOL", "123456");

        c.adicionarFederacao(f);

        assertEquals(f, c.getFederacao());
        assertTrue(Federacao.getListaFederacao().contains(f));
    }

    @Test
    void deveAdicionarEquipeAoCampeonato() {
        Campeonato c = new Campeonato("Copa do Brasil", "Brasil", 2000000, 3);
        Equipe e = new Equipe("Flamengo", "111", 1895, "RJ");

        c.adicionarEquipe(e);

        assertFalse(c.getLista_equipes().contains(e));
    }
}

