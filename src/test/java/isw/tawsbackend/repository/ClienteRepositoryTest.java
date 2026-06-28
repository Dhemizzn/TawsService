package isw.tawsbackend.repository;

import isw.tawsbackend.model.Cliente;
import isw.tawsbackend.model.Dni;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    private String generarDni() {
        return String.valueOf(10000000 + new Random().nextInt(90000000));
    }

    @Test
    void existsByDni_NumeroDni_DebeRetornarTrue() {
        String numeroDni = generarDni();
        Dni dni = Dni.builder().numeroDni(numeroDni).build();

        Cliente cliente = Cliente.builder()
                .nombre("Dhemiz")
                .apellidoPrimero("Perez")
                .apellidoSegundo("Gomez")
                .email("test1" + numeroDni + "@uni.edu.pe")
                .dni(dni)
                .password("123456")
                .build();
        clienteRepository.save(cliente);

        boolean existe = clienteRepository.existsByDni_NumeroDni(numeroDni);
        assertTrue(existe, "El repositorio debería encontrar el DNI registrado");
    }

    @Test
    void existsByEmail_DebeRetornarTrue() {
        String email = "test2" + System.currentTimeMillis() + "@uni.edu.pe";
        Dni dni = Dni.builder().numeroDni(generarDni()).build();

        Cliente cliente = Cliente.builder()
                .nombre("Dhemiz")
                .apellidoPrimero("Perez")
                .apellidoSegundo("Gomez")
                .email(email)
                .dni(dni)
                .password("123456")
                .build();
        clienteRepository.save(cliente);

        boolean existe = clienteRepository.existsByEmail(email);
        assertTrue(existe, "El repositorio debería encontrar el email registrado");
    }

    @Test
    void findByEmail_DebeRetornarClienteCuandoExiste() {
        String email = "contacto" + System.currentTimeMillis() + "@uni.edu.pe";
        Dni dni = Dni.builder().numeroDni(generarDni()).build();

        Cliente cliente = Cliente.builder()
                .nombre("Dhemiz")
                .apellidoPrimero("Perez")
                .apellidoSegundo("Gomez")
                .email(email)
                .dni(dni)
                .password("123456")
                .build();
        clienteRepository.save(cliente);

        Optional<Cliente> resultado = clienteRepository.findByEmail(email);
        assertTrue(resultado.isPresent(), "El cliente debería existir");
        assertEquals(email, resultado.get().getEmail());
    }
}