package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "viaje_terrestre", schema = "TAWS")
public class ViajeTerrestre {

    @Id
    @Column(name = "id_transporte")
    private String idTransporte;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_transporte")
    private Transporte transporte;

    @Column(name = "numero_viaje")
    private String numeroViaje;

    private String embarque;

}

