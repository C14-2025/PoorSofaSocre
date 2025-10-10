package pessoaJuridicaTeste;

import org.example.futebol.pessoa_juridica.Equipe;
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
}
