package isw.tawsbackend.service;

import isw.tawsbackend.dto.AuthLoginRequest;
import isw.tawsbackend.dto.ClienteRequest;

public class ClienteValidator {
    private static int MAXSIZE_EMAIL = 100;
    private static int MAXSIZE_PASSWORD = 30;
    private static int MAXSIZE_NOMBRE = 50;
    private static int MAXSIZE_APELLIDO = 50;

    private static int MINSIZE_PASSWORD = 8;

    private static int SIZE_DNI = 8;
    private static int SIZE_TELEFONO = 9;

    private static String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-ñÑ]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-ñÑ]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static String NOMBRE_REGEX = "[a-zA-ZñÑ]+";
    private static String APELLIDO_REGEX = "[a-zA-ZñÑ][a-zA-ZñÑ ]+[a-zA-ZñÑ]";
    private static String TELEFONO_REGEX = "[0-9]+";
    private static String DNI_REGEX = "[0-9]+";

    public static void validateLoginData(AuthLoginRequest request) {
        request.setEmail(request.getEmail().trim());
        // password does not require it since space is valid in any part of a password.

        if (request.getEmail().isEmpty() || request.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Llenar todos los campos.");
        }
        if (request.getEmail().length() > MAXSIZE_EMAIL
                || !request.getEmail().matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Formato de correo inválido: Debe tener forma similar a \"*@*.*\" con máximo de 100 caracteres.");
        }
        if (request.getPassword().length() > MAXSIZE_PASSWORD
            || request.getPassword().length() < MINSIZE_PASSWORD) {
            throw new IllegalArgumentException("Formato de contraseña inválido: Debe tener de 8 a 30 caracteres.");
        }
    }

    public static void validateRegisterData(ClienteRequest request) {
        request.setEmail(request.getEmail());
        request.setApellidoPrimero(request.getApellidoPrimero());
        request.setApellidoSegundo(request.getApellidoSegundo());
        request.setNombre(request.getNombre());
        request.setNumeroDni(request.getNumeroDni());
        request.setTelefono(request.getTelefono());
        // password does not require it since space is valid in any part of a password.

        if (request.getEmail().isEmpty() || request.getPassword().isEmpty() || request.getApellidoPrimero().isEmpty()
                || request.getApellidoSegundo().isEmpty() || request.getNombre().isEmpty() || request.getNumeroDni().isEmpty()
                || request.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("Llenar todos los campos.");
        }
        if (request.getNombre().length() > MAXSIZE_NOMBRE
                || !request.getNombre().matches(NOMBRE_REGEX)) {
            throw new IllegalArgumentException("Formato de nombre inválido: Solo letras con máximo de 50 caracteres y en una sola palabra.");
        }
        if (request.getApellidoPrimero().length() > MAXSIZE_APELLIDO
                || !request.getApellidoPrimero().matches(APELLIDO_REGEX)
                || request.getApellidoSegundo().length() > MAXSIZE_APELLIDO
                || !request.getApellidoSegundo().matches(APELLIDO_REGEX)) {
            throw new IllegalArgumentException("Formato de apellidos inválido: Solo letras y espacios con máximo de 50 caracteres para cada apellido.");
        }
        if (request.getEmail().length() > MAXSIZE_EMAIL
                || !request.getEmail().matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Formato de correo inválido: Debe tener forma similar a \"*@*.*\" con máximo de 100 caracteres.");
        }
        if (request.getTelefono().length() != SIZE_TELEFONO
                || !request.getTelefono().matches(TELEFONO_REGEX)) {
            throw new IllegalArgumentException("Formato de teléfono inválido: Debe tener 9 dígitos exactos.");
        }
        if (request.getNumeroDni().length() != SIZE_DNI
                || !request.getNumeroDni().matches(DNI_REGEX)) {
            throw new IllegalArgumentException("Formato de DNI inválido: Debe tener 8 dígitos exactos.");
        }
        if (request.getPassword().length() > MAXSIZE_PASSWORD
                || request.getPassword().length() < MINSIZE_PASSWORD) {
            throw new IllegalArgumentException("Formato de contraseña inválido: Debe tener 30 caracteres máximo");
        }
    }
}

