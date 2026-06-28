package isw.tawsbackend.service;

import isw.tawsbackend.dto.AuthLoginRequest;
import isw.tawsbackend.dto.ClienteRequest;
import isw.tawsbackend.dto.ClienteResponse;
import isw.tawsbackend.model.Cliente;
import isw.tawsbackend.model.Dni;
import isw.tawsbackend.model.Ruc;
import isw.tawsbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponse registrarCliente(ClienteRequest request) {
        try {
            ClienteValidator.validateRegisterData(request);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        if (clienteRepository.existsByDni_NumeroDni(request.getNumeroDni())) {
            throw new RuntimeException("El cliente con este DNI ya está registrado");
        }
        if(clienteRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El correo que intenta registrar ya existe");
        }

        Dni dniEntidad = Dni.builder()
                .numeroDni(request.getNumeroDni())
                .build();

        Ruc rucEntidad = (request.getNumeroRuc() != null) ?
                Ruc.builder().numeroRuc(request.getNumeroRuc()).build() : null;

        Cliente nuevoCliente = Cliente.builder()
                .nombre(request.getNombre())
                .apellidoPrimero(request.getApellidoPrimero())
                .apellidoSegundo(request.getApellidoSegundo())
                .telefono(request.getTelefono())
                .email(request.getEmail())
                .password(request.getPassword())
                .dni(dniEntidad)
                .ruc(rucEntidad)
                .build();

        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
        return mapearAResponse(clienteGuardado);
    }

    public ClienteResponse login(AuthLoginRequest request) {
        try {
            ClienteValidator.validateLoginData(request);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        Cliente cliente = clienteRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales invalidas"));

        if (!cliente.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }
        return mapearAResponse(cliente);
    }

    public List<ClienteResponse> obtenerClientes() {
        return clienteRepository.findAll().stream()
                .map(this::mapearAResponse)
                .collect(Collectors.toList());
    }

    private ClienteResponse mapearAResponse(Cliente cliente) {
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellidoPrimero(cliente.getApellidoPrimero())
                .apellidoSegundo(cliente.getApellidoSegundo())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .numeroDni(cliente.getDni() != null ? cliente.getDni().getNumeroDni() : null)
                .numeroRuc(cliente.getRuc() != null ? cliente.getRuc().getNumeroRuc() : null)
                .build();
    }

    // Metodo para actualizar datos basicos del perfil
    public ClienteResponse actualizarPerfil(String idCliente, ClienteRequest request) {
        // Buscamos al cliente o lanzamos error si no existe
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizamos los campos
        cliente.setNombre(request.getNombre());
        cliente.setApellidoPrimero(request.getApellidoPrimero());
        cliente.setApellidoSegundo(request.getApellidoSegundo());
        cliente.setTelefono(request.getTelefono());
        // Nota: Por seguridad, no actualizamos el email ni la password aqui directamente

        // Guardamos los cambios
        Cliente clienteActualizado = clienteRepository.save(cliente);

        return mapearAResponse(clienteActualizado);
    }
}