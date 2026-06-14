package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "observacion", schema = "TAWS")
public class Observacion {

    @Id
    @Column(name = "id_observacion")
    private String idObservacion;

    private String estado;

    private String mensaje;

    private String respuesta;

    @OneToOne
    @JoinColumn(name = "id_cotizacion")
    private Cotizacion cotizacion;

}

