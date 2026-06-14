package isw.tawsbackend.repository;

import isw.tawsbackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    boolean existsByDni_NumeroDni(String numeroDni);

    Optional<Cliente> findByEmail(String email);

}