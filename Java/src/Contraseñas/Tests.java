package Contraseñas;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    @Test
    void passwordLength(){
        ValidadorPasswords validador = new ValidadorPasswords();
        assertEquals(true, validador.longitudMinima("Humberto123"));
    }

    @Test
    void passwordMayusucula(){
        ValidadorPasswords validador = new ValidadorPasswords();
        assertEquals(true, validador.mayusculas("CabezadeMandarina"));
    }

    @Test
    void passwordNumero(){
        ValidadorPasswords validador = new ValidadorPasswords();
        assertEquals(true, validador.numero("Humberto123"));
    }

    @Test
    void validPassword(){
        ValidadorPasswords validador = new ValidadorPasswords();
        assertTrue(validador.validPassword("Humberto123"));
    }
}
