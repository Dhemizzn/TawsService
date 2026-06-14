package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boleta", schema = "TAWS")
public class Boleta {

    @Id
    @Column(name = "id_transaccion")
    private String idTransaccion;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;

    @Column(name = "numero_boleta")
    private String numeroBoleta;

}

