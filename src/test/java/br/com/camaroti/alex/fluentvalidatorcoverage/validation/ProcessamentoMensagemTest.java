package br.com.camaroti.alex.fluentvalidatorcoverage.validation;

import br.com.camaroti.alex.fluentvalidatorcoverage.ProcessamentoMensagem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcessamentoMensagemTest {
    
    ProcessamentoMensagem pm = new ProcessamentoMensagem();
    
    @Test
    public void testProcessamentoMensagem(){
        String saudacao = pm.processarSaudacao("Guerreiro");
        Assertions.assertEquals("Olá Guerreiro", saudacao);
    }
    
}
