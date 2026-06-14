package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaccion", schema = "TAWS")
public class Transaccion {

    @Id
    @Column(name = "id_transaccion")
    private String idTransaccion;

    private LocalDate fecha;

    private BigDecimal monto;

    @OneToOne
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;

}

