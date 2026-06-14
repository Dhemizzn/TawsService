package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turismo", schema = "TAWS")
public class Turismo {

    @Id
    @Column(name = "id_turismo")
    private String idTurismo;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    @Column(name = "cnt_personas")
    private Integer cntPersonas;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Empresa proveedor;

}

