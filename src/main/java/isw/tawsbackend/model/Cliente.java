package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente", schema = "TAWS")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private String idCliente;

    private String nombre;

    @Column(name = "apellido_primero")
    private String apellidoPrimero;

    @Column(name = "apellido_segundo")
    private String apellidoSegundo;

    private String telefono;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dni_id")
    private Dni dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ruc_id")
    private Ruc ruc;

    // Campo obligatorio para el inicio de sesion (HU01)
    @Column(name = "password", nullable = false)
    private String password;

}
