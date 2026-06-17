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

    private String nombre;
    private String apellidoPrimero;
    private String apellidoSegundo;
    private String telefono;
    private String email;
    private String numeroDni;
    private String numeroRuc;
    private String password;
}