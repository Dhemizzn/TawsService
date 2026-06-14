package isw.tawsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    // Datos basicos del cliente
    private String nombre;
    private String apellidoPrimero;
    private String apellidoSegundo;
    private String telefono;
    private String email;

    // Relaciones: Solo pedimos los IDs referenciales (La Regla de Oro)
    private String numeroDni;

    // Nota: El RUC es opcional (0..1 segun tu diagrama), asi que puede ser null
    private String numeroRuc;

    // Se añade la contraseña al formulario de registro
    private String password;
}