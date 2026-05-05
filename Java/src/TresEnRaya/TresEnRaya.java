package TresEnRaya;

public class TresEnRaya {

    private char[][] tablero;
    private char turnoActual;
    private boolean juegoTerminado;

    public TresEnRaya() {
        tablero = new char[3][3];
        reiniciar();
    }

    public void reiniciar() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
        turnoActual = 'X';
        juegoTerminado = false;
    }

    public void hacerMovimiento(int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2)
            throw new IllegalArgumentException("Posición fuera del tablero");
        if (juegoTerminado)
            throw new IllegalStateException("El juego ya ha terminado");
        if (tablero[fila][columna] != ' ')
            throw new IllegalStateException("Casilla ya ocupada");

        tablero[fila][columna] = turnoActual;

        if (comprobarGanador(turnoActual) || tableroLleno())
            juegoTerminado = true;
        else
            turnoActual = (turnoActual == 'X') ? 'O' : 'X';
    }

    public char obtenerCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public char[][] obtenerTablero() {
        char[][] copia = new char[3][3];
        for (int i = 0; i < 3; i++)
            copia[i] = tablero[i].clone();
        return copia;
    }

    public char obtenerTurno() {
        return turnoActual;
    }

    public char obtenerGanador() {
        if (comprobarGanador('X')) return 'X';
        if (comprobarGanador('O')) return 'O';
        return ' ';
    }

    public boolean hayGanador() {
        return comprobarGanador('X') || comprobarGanador('O');
    }

    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ') {
                    return false;
                }
        return true;
    }

    public boolean esEmpate() {
        return tableroLleno() && !hayGanador();
    }

    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    private boolean comprobarGanador(char jugador) {
        for (int i = 0; i < 3; i++)
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador)
                return true;

        for (int j = 0; j < 3; j++)
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador)
                return true;

        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador)
            return true;

        return tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador;
    }
}
