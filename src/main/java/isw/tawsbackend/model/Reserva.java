package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva", schema = "TAWS")
public class Reserva {

    @Id
    @Column(name = "id_reserva")
    private String idReserva;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Empresa hotel;

}

