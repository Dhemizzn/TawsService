package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paquete", schema = "TAWS")
public class Paquete {

    @Id
    @Column(name = "id_paquete")
    private String idPaquete;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_cotizacion")
    private Cotizacion cotizacion;

}

