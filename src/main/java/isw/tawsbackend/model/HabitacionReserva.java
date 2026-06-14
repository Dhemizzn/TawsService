package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habitacion_reserva", schema = "TAWS")
public class HabitacionReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @Column(name = "numero_habitacion")
    private Integer numeroHabitacion;

}

