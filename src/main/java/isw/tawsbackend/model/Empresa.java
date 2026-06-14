package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa", schema = "TAWS")
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    private String idEmpresa;

    private String nombre;

    private String direccion;

    @Column(name = "ruc")
    private String ruc;

}

