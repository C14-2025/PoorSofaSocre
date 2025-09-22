package pessoa_fisicaTeste;

import org.example.futebol.pessoa_fisica.Jogador;
import org.example.futebol.pessoa_fisica.Tecnico;
import org.example.futebol.pessoa_juridica.Equipe;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class TecnicoTest {
    private Tecnico tecnico;

    @Test
    public void testConstrutor() {
        tecnico = new Tecnico("Guardiola",54,"11111111111","Espanha");
        assertEquals("Guardiola", tecnico.getNome());
        assertEquals(54, tecnico.getIdade());
        assertEquals("11111111111", tecnico.getCpf());
        assertEquals("Espanha", tecnico.getNacionalidade());
    }

    @org.junit.jupiter.api.Test
    void testeContratar() {
        Equipe equipeDestino = Mockito.mock(Equipe.class);
        Tecnico tecnico = new Tecnico("Guardiola",54,"11111111111","Espanha");

        tecnico.contratar(equipeDestino);

        Assertions.assertEquals(equipeDestino, tecnico.getEquipe());
    }
}
