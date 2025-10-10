package pessoa_juridicaTeste;

import org.example.futebol.campeonatos.Campeonato;
import org.example.futebol.pessoa_fisica.Jogador;
import org.example.futebol.pessoa_fisica.Tecnico;
import org.example.futebol.pessoa_juridica.Equipe;
import org.example.futebol.pessoa_juridica.Patrocinador;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EquipeTest {

    @Test
    void deveAdicionarPatrocinadorEChamarMetodoDoPatrocinador() {
        Equipe equipe = new Equipe("Flamengo", "12345678000100", 1895, "Rio de Janeiro");
        Patrocinador patrocinadorMock = mock(Patrocinador.class);

        equipe.adicionarPatrocinador(patrocinadorMock, 500000);

        assertTrue(equipe.getValor_patrocinadores().contains(500000));
        verify(patrocinadorMock, times(1)).adicionarEquipe(equipe, 500000);
    }

    @Test
    void deveAdicionarCampeonatoEChamarMetodoNoCampeonato() {
        Equipe equipe = new Equipe("Corinthians", "98765432000100", 1910, "São Paulo");
        Campeonato campeonatoMock = mock(Campeonato.class);

        equipe.adicionarCampeonato(campeonatoMock);

        assertTrue(equipe.getLista_jogadores().isEmpty()); // só pra garantir consistência
        verify(campeonatoMock, times(1)).adicionarEquipe(equipe);
    }

    @Test
    void deveTransferirJogadorEntreEquipes() {
        Equipe origem = new Equipe("Flu", "123", 1902, "RJ");
        Equipe destino = new Equipe("Vasco", "321", 1898, "RJ");
        Jogador jogador = new Jogador("Fred", 37, "111", "Brasil", "Atacante");

        origem.adcionaJogador(jogador);
        origem.transferirJogador(jogador, destino);

        assertFalse(origem.getLista_jogadores().contains(jogador));
        assertTrue(destino.getLista_jogadores().contains(jogador));
        assertEquals(destino, jogador.getEquipe());
    }

    @Test
    void deveTransferirTecnicoEntreEquipes() {
        Equipe origem = new Equipe("Palmeiras", "456", 1914, "SP");
        Equipe destino = new Equipe("Santos", "654", 1912, "SP");
        Tecnico tecnico = new Tecnico("Luxemburgo", 70, "555", "Brasil");

        origem.adcionaTecnico(tecnico);
        origem.transferirTecnico(tecnico, destino);

        assertNull(origem.getTecnico());
        assertEquals(destino, tecnico.getEquipe());
        assertEquals(tecnico, destino.getTecnico());
    }

}
