package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "viaje_aereo", schema = "TAWS")
public class ViajeAereo {

    @Id
    @Column(name = "id_transporte")
    private String idTransporte;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_transporte")
    private Transporte transporte;

    @Column(name = "numero_vuelo")
    private String numeroVuelo;

    private String terminal;

    @Column(name = "clase_vuelo")
    private String claseVuelo;

    @Column(name = "equipaje_incluido")
    private Boolean equipajeIncluido;

}

