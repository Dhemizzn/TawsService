package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ruc", schema = "TAWS")
public class Ruc {

    @Id
    @Column(name = "numero_ruc")
    private String numeroRuc;

    @Column(name = "direccion_fiscal")
    private String direccionFiscal;

}
