package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Data //Crea metodos getters,setters,toString,etc
@Entity // Representa una tabla en mi base de datos.
@Builder //Activa el patron de diseno builder que permite construir de forma mas elegnate y rapida.
@NoArgsConstructor // Constructor vacio
@AllArgsConstructor // Constructor con todo los parametros
@Table(name = "actividad", schema = "TAWS")
public class Actividad {

    @Id//Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Delega la responsabilidad de crear IDs a postgre
    @Column(name = "id_actividad")//esta notacion conecta mi variable con la columna
    private Integer idActividad;

    @ManyToOne//Relacion Muchos a uno
    @JoinColumn(name = "id_turismo")//Avisa cual es la columna fisica que se usa para guardar esta relacion(solo el id)
    private Turismo turismo;

    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_final")
    private LocalTime horaFinal;

}

