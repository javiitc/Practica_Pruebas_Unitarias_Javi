package Contraseñas;

public class ValidadorPasswords {

    public boolean longitudMinima(String password) {
        return password.length() >= 8;
    }

    public boolean mayusculas(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean numero(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean validPassword(String password) {
        if (longitudMinima(password) && numero(password) && mayusculas(password)) {
            return true;
        }
        return false;
    }
}
