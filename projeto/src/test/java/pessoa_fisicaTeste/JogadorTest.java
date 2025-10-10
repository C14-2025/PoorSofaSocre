package pessoa_fisicaTeste;

import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Torcedor;
import br.inatel.futebol.pessoa_juridica.Equipe;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JogadorTest {

    @Test
    void testConstrutor() {
        Jogador jogador = new Jogador("Pelé", 40, "12345678900", "Brasil", "Atacante");

        assertEquals("Pelé", jogador.getNome());
        assertEquals(40, jogador.getIdade());
        assertEquals("12345678900", jogador.getCpf());
        assertEquals("Brasil", jogador.getNacionalidade());
        assertEquals("Atacante", jogador.getPosicao());
    }

    @Test
    void testContratarComEquipeMock() {
        //cria mock de Equipe
        Equipe equipeMock = Mockito.mock(Equipe.class);

        // cria jogador real
        Jogador jogador = new Jogador("Ronaldo", 30, "98765432100", "Brasil", "Atacante");

        // chama o metodo que depende de Equipe
        jogador.contratar(equipeMock);

        // verifica se o metodo adcionaJogador(this) foi chamado
        verify(equipeMock).adcionaJogador(jogador);

        // garante que o jogador ficou vinculado à equipe
        assertEquals(equipeMock, jogador.getEquipe());
    }

    @Test
    void testTransferir() {
        Equipe equipeDestino = Mockito.mock(Equipe.class);
        Jogador jogador = new Jogador("Neymar", 32, "11223344556", "Brasil", "Atacante");

        jogador.transferir(equipeDestino);

        assertEquals(equipeDestino, jogador.getEquipe());
    }

    @Test
    void deveIncrementarTorcedoresAoCriarNovoTorcedor() {
        Equipe equipe = new Equipe("Galo", "999", 1908, "BH");
        int torcedoresAntes = Equipe.getListaEquipes().get(0).getLista_jogadores().size();

        new Torcedor("Zé", 25, "111", equipe);

        assertEquals("Galo", equipe.getNome());
    }


}
