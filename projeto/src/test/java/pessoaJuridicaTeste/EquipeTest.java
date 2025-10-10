package pessoaJuridicaTeste;

import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Tecnico;
import br.inatel.futebol.pessoa_juridica.Equipe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

public class EquipeTest {

    @Test
    public void testConstrutor(){
        Equipe equipe = new Equipe("São Paulo", "11111111111", 1930, "Brasil");

        assertEquals("São Paulo", equipe.getNome());
        assertEquals("11111111111", equipe.getCnpj());
        assertEquals(1930, equipe.getFundacao());
        assertEquals("Brasil", equipe.getSede());
    }

    @Test
    public void testTransferirTecnico(){
        Tecnico tecnico1Mock = Mockito.mock(Tecnico.class);
        Tecnico tecnico2Mock = Mockito.mock(Tecnico.class);

        Equipe equipeOrigem = new Equipe("São Paulo", "11111111111", 1930, "Brasil");
        Equipe equipeDestino = new Equipe("Flamengo", "22222222222", 1895, "Brasil");

        tecnico1Mock.contratar(equipeOrigem);
        tecnico2Mock.contratar(equipeDestino);

        equipeOrigem.transferirTecnico(tecnico1Mock, equipeDestino);

        assertEquals(equipeDestino.getTecnico(), tecnico1Mock);
        assertEquals(tecnico1Mock, equipeDestino.getTecnico());
        assertNull(equipeOrigem.getTecnico());
        assertNull(tecnico2Mock.getEquipe());
    }

    @Test
    public void testTransferirJogador(){
        Jogador jogador1Mock = Mockito.mock(Jogador.class);
        Jogador jogador2Mock = Mockito.mock(Jogador.class);
        Jogador jogador3Mock = Mockito.mock(Jogador.class);

        Equipe equipeOrigem = new Equipe("São Paulo", "11111111111", 1930, "Brasil");
        Equipe equipeDestino = new Equipe("Flamengo", "22222222222", 1895, "Brasil");

        jogador1Mock.contratar(equipeOrigem);
        jogador2Mock.contratar(equipeOrigem);
        jogador3Mock.contratar(equipeDestino);

        equipeOrigem.transferirJogador(jogador1Mock, equipeDestino);

        assertEquals(equipeDestino.getLista_jogadores().get(0), jogador1Mock);
    }
}
