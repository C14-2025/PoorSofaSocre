package futebolTests;

import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_juridica.Equipe;
import br.inatel.futebol.pessoa_juridica.Federacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CampeonatoTest {

    private Campeonato campeonato;

    @BeforeEach
    void setUp() {
        campeonato = new Campeonato("Brasileirão", "Brasil", 1000000, 1);
    }

    @Test
    void deveCriarCampeonatoEAdicionarNaListaEstatica() {
        assertEquals("Brasileirão", campeonato.getNome());
        assertEquals("Brasil", campeonato.getLocal());
        assertEquals(1000000, campeonato.getPremio());
        assertTrue(Campeonato.getListaCampeonato().contains(campeonato));
    }

    @Test
    void deveAdicionarFederacaoAoCampeonatoMock() {
        // cria um mock de Federacao
        Federacao federacaoMock = Mockito.mock(Federacao.class);

        campeonato.adicionarFederacao(federacaoMock);

        // verifica se federacao foi setada corretamente
        assertEquals(federacaoMock, campeonato.getFederacao());

        // verifica se o método adicionarCampeonato foi chamado dentro do Campeonato
        verify(federacaoMock, times(1)).adicionarCampeonato(campeonato);
    }

    @Test
    void deveAdicionarEquipeAoCampeonatoMock() {
        // cria um mock de Equipe
        Equipe equipeMock = Mockito.mock(Equipe.class);

        campeonato.adicionarEquipe(equipeMock);

        // verifica se a equipe foi adicionada à lista do campeonato
        assertTrue(campeonato.getLista_equipes().contains(equipeMock));

        // opcional: podemos verificar se equipeMock interagiu de alguma forma (nesse caso não interage)
        verifyNoInteractions(equipeMock);
    }
}
