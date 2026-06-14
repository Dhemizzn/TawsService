package isw.tawsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginRequest {

    // Credenciales solicitadas para autorizar el acceso
    private String email;
    private String password;

}