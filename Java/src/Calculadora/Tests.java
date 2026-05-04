    package Calculadora;

    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    public class Tests {

        @Test
        void testSumar() {
            Calculadora calc = new Calculadora();
            assertEquals(5, calc.sumar(2, 3));
        }

        @Test
        void testSumarNegativos() {
            Calculadora calc = new Calculadora();
            assertEquals(-5, calc.sumar(-2, -3));
        }
        @Test
        void testRestar() {
            Calculadora calc = new Calculadora();
            assertEquals(2, calc.restar(5, 3));
        }

        @Test
        void testMultiplicar() {
            Calculadora calc = new Calculadora();
            assertEquals(20, calc.multiplicar(5, 4));
        }

        @Test
        void testMultiplicarCero() {
            Calculadora calc = new Calculadora();
            assertEquals(0, calc.multiplicar(5, 0));
        }

        @Test
        void testDivision() {
            Calculadora calc = new Calculadora();
            assertEquals(5, calc.dividir(10, 2));
        }

        @Test
        void testDivisionCero() {
            Calculadora calc = new Calculadora();
            assertThrows(ArithmeticException.class, () -> calc.dividir(10, 0));
        }

        @Test
        void testDivisionNegativos() {
            Calculadora calc = new Calculadora();
            assertEquals(1, calc.dividir(-5, -5));
        }
    }
