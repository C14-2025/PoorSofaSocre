package pessoa_fisicaTeste;

import org.example.futebol.pessoa_fisica.Jogador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JogadorTest {
    private Jogador jogador;

    @Test
    public void testConstrutor() {
        jogador = new Jogador("Pelé",40,"12345678900","Brasil","Atacante");
        assertEquals("Pelé", jogador.getNome());
        assertEquals(40, jogador.getIdade());
        assertEquals("12345678900", jogador.getCpf());
        assertEquals("Brasil", jogador.getNacionalidade());
        assertEquals("Atacante", jogador.getPosicao());
    }
}
