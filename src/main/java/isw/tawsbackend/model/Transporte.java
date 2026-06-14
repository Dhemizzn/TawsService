package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transporte", schema = "TAWS")
public class Transporte {

    @Id
    @Column(name = "id_transporte")
    private String idTransporte;

    @Column(name = "fecha_partida")
    private LocalDate fechaPartida;

    @Column(name = "fecha_llegada")
    private LocalDate fechaLlegada;

    @Column(name = "hora_partida")
    private LocalTime horaPartida;

    @Column(name = "hora_llegada")
    private LocalTime horaLlegada;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

}

