package isw.tawsbackend.controller;

import isw.tawsbackend.dto.AuthLoginRequest;
import isw.tawsbackend.dto.ClienteRequest;
import isw.tawsbackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody ClienteRequest request) {
        try {
            return new ResponseEntity<>(clienteService.registrarCliente(request), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthLoginRequest request) {
        try {
            return ResponseEntity.ok(clienteService.login(request.getEmail(), request.getPassword()));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerClientes() {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<?> actualizarPerfil(@PathVariable String idCliente, @RequestBody ClienteRequest request) {
        try {
            return ResponseEntity.ok(clienteService.actualizarPerfil(idCliente, request));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}