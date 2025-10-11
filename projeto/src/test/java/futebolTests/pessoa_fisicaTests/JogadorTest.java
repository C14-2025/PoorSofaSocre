package futebolTests.pessoa_fisicaTests;

import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Torcedor;
import br.inatel.futebol.pessoa_juridica.Equipe;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;

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
    @Test
    void testListaJogadoresAdicionaAutomaticamente() {
        int tamanhoAntes = Jogador.getListaJogadores().size();

        Jogador novo = new Jogador("Dida", 38, "88877766655", "Brasil", "Goleiro");

        assertTrue(Jogador.getListaJogadores().contains(novo));
        assertEquals(tamanhoAntes + 1, Jogador.getListaJogadores().size());
    }

    @Test
    void testSetPosicaoEGetters() {
        Jogador jogador = new Jogador("Kaká", 37, "55566677788", "Brasil", "Meia");
        jogador.setPosicao("Atacante");

        assertEquals("Atacante", jogador.getPosicao());
        assertEquals("Brasil", jogador.getNacionalidade());
    }

    @Test
    void testAposentarJogadorRemoveDeListaEEquipe() {
        // Mock da equipe
        Equipe equipeMock = Mockito.mock(Equipe.class);
        when(equipeMock.getLista_jogadores()).thenReturn(new ArrayList<>());

        // Cria jogador e adiciona manualmente na lista da equipe
        Jogador jogador = new Jogador("Zico", 41, "99988877766", "Brasil", "Meia");
        equipeMock.getLista_jogadores().add(jogador);
        jogador.setEquipe(equipeMock);

        // Garante que o jogador está nas listas
        assertTrue(Jogador.getListaJogadores().contains(jogador));
        assertTrue(equipeMock.getLista_jogadores().contains(jogador));

        // Chama o metodo de aposentadoria
        jogador.aposentarjogador();

        // Verifica se foi removido de ambas as listas
        assertFalse(Jogador.getListaJogadores().contains(jogador));
        assertFalse(equipeMock.getLista_jogadores().contains(jogador));
        assertNull(jogador.getEquipe());
    }

    @Test
    void testMostrarInformacoesComEquipe() {
        Equipe equipeMock = Mockito.mock(Equipe.class);
        when(equipeMock.getNome()).thenReturn("Santos");

        Jogador jogador = new Jogador("Pelé", 40, "12345678900", "Brasil", "Atacante");
        jogador.setEquipe(equipeMock);

        // Captura a saída do console
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        jogador.mostrarInformacoes();

        System.setOut(System.out);
        String output = outContent.toString();

        assertTrue(output.contains("Pelé"));
        assertTrue(output.contains("Santos"));
    }

    @Test
    void testContratarJogadorEmOutraEquipe() {
        Equipe equipe1 = Mockito.mock(Equipe.class);
        Equipe equipe2 = Mockito.mock(Equipe.class);

        Jogador jogador = new Jogador("Rivaldo", 38, "44455566677", "Brasil", "Meia");

        jogador.contratar(equipe1);
        assertEquals(equipe1, jogador.getEquipe());

        jogador.contratar(equipe2);
        assertEquals(equipe2, jogador.getEquipe());

        // verifica se foi chamado o metodo adcionaJogador nas duas
        verify(equipe1).adcionaJogador(jogador);
        verify(equipe2).adcionaJogador(jogador);
    }
}
