package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "factura", schema = "TAWS")
public class Factura {

    @Id
    @Column(name = "id_transaccion")
    private String idTransaccion;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;

    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "direccion_fiscal")
    private String direccionFiscal;

    @Column(name = "numero_factura")
    private String numeroFactura;

}

