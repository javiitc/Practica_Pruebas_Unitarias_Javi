package TresEnRaya;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    @Test
    void colocarFichaCorrectamente () {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0,2);

        assertEquals('X', juego.obtenerCasilla(0,2));
    }

    @Test
    void colocarFichaFuera (){
        TresEnRaya juego = new TresEnRaya();

        assertThrows(IllegalArgumentException.class, () -> juego.hacerMovimiento(1,3));
    }

    @Test
    void colocarFichaCasillaOcupada() {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0,2);

        assertThrows(IllegalStateException.class, () -> juego.hacerMovimiento(0,2));
    }

    @Test
    void ganadorFila() {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0,0); // Casilla X
        juego.hacerMovimiento(1,0); // Casilla O
        juego.hacerMovimiento(0,1); // Casilla X
        juego.hacerMovimiento(1,1); // Casilla O
        juego.hacerMovimiento(0,2); // Casilla X

        assertEquals('X', juego.obtenerGanador()); // Ganador X por fila
    }

    @Test
    void ganadorColumna() {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0,0);
        juego.hacerMovimiento(0,1);
        juego.hacerMovimiento(1,0);
        juego.hacerMovimiento(1,1);
        juego.hacerMovimiento(2,0);

        assertEquals('X', juego.obtenerGanador());
    }

    @Test
    void ganadorDiagonal() {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0,0);
        juego.hacerMovimiento(0,1);
        juego.hacerMovimiento(1,1);
        juego.hacerMovimiento(2,0);
        juego.hacerMovimiento(2,2);

        assertEquals('X', juego.obtenerGanador());
    }

    @Test
    void ganadorDiagonalSecundaria() {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0,2);
        juego.hacerMovimiento(0,1);
        juego.hacerMovimiento(1,1);
        juego.hacerMovimiento(2,2);
        juego.hacerMovimiento(2,0);

        assertEquals('X', juego.obtenerGanador());
    }

    @Test
    void empate() {
        TresEnRaya juego = new TresEnRaya();
        juego.hacerMovimiento(0, 0); // X
        juego.hacerMovimiento(0, 1); // O
        juego.hacerMovimiento(0, 2); // X
        juego.hacerMovimiento(1, 2); // O
        juego.hacerMovimiento(1, 0); // X
        juego.hacerMovimiento(2, 0); // O
        juego.hacerMovimiento(1, 1); // X
        juego.hacerMovimiento(2, 2); // O
        juego.hacerMovimiento(2, 1); // X

        assertTrue(juego.esEmpate());
    }
}
