package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cotizacion", schema = "TAWS")
public class Cotizacion {

    @Id
    @Column(name = "id_cotizacion")
    private String idCotizacion;

    private String estado;

    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    @Column(name = "region_partida")
    private String regionPartida;

    @Column(name = "region_destino")
    private String regionDestino;

    @Column(name = "lugar_turistico")
    private String lugarTuristico;

    @Column(name = "fecha_partida")
    private LocalDate fechaPartida;

    @Column(name = "fecha_regreso")
    private LocalDate fechaRegreso;

    @Column(name = "hora_partida")
    private LocalTime horaPartida;

    @Column(name = "hora_regreso")
    private LocalTime horaRegreso;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "turismo_id")
    private Turismo turismo;

    @ManyToOne
    @JoinColumn(name = "transporte_ida")
    private Transporte transporteIda;

    @ManyToOne
    @JoinColumn(name = "transporte_vuelta")
    private Transporte transporteVuelta;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

}
