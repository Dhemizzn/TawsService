package isw.tawsbackend.repository;

import isw.tawsbackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    // Consulta derivada de Spring Data JPA.
    // Verifica la existencia de un cliente en la base de datos
    // navegando hacia la relacion "dni" y evaluando el atributo "numeroDni".
    // Retorna true si el documento de identidad ya se encuentra registrado.
    boolean existsByDni_NumeroDni(String numeroDni);

    // Consulta personalizada para recuperar un cliente utilizando su correo electronico.
    // Se utiliza Optional para manejar de forma segura el caso en que el correo no exista.
    Optional<Cliente> findByEmail(String email);

}
