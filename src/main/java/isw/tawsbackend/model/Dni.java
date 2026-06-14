package isw.tawsbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dni", schema = "TAWS")
public class Dni {

    @Id
    @Column(name = "numero_dni")
    private String numeroDni;

    @Column(name = "url_imagen")
    private String urlImagen;

}

