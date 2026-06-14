package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asiento_avion", schema = "TAWS")
public class AsientoAvion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asiento")
    private Integer idAsiento;

    @ManyToOne
    @JoinColumn(name = "id_transporte")
    private ViajeAereo viaje;

    @Column(name = "numero_asiento")
    private String numeroAsiento;

}

