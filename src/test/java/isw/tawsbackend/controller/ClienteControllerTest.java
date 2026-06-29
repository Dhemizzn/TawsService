package isw.tawsbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import isw.tawsbackend.dto.AuthLoginRequest;
import isw.tawsbackend.dto.ClienteRequest;
import isw.tawsbackend.dto.ClienteResponse;
import isw.tawsbackend.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc(addFilters = false)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClienteService clienteService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void registrarCliente_DebeRetornarCreated() throws Exception {

        ClienteRequest request = ClienteRequest.builder()
                .nombre("Dhemiz")
                .email("test@uni.edu.pe")
                .numeroDni("12345678")
                .password("123456")
                .build();

        ClienteResponse response = ClienteResponse.builder()
                .idCliente("1")
                .nombre("Dhemiz")
                .email("test@uni.edu.pe")
                .numeroDni("12345678")
                .build();

        when(clienteService.registrarCliente(any(ClienteRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idCliente").value("1"))
                .andExpect(jsonPath("$.nombre").value("Dhemiz"));
    }

    @Test
    void registrarCliente_DebeRetornarBadRequest_CuandoDniYaExiste() throws Exception {

        ClienteRequest request = ClienteRequest.builder()
                .numeroDni("12345678")
                .build();

        when(clienteService.registrarCliente(any(ClienteRequest.class)))
                .thenThrow(new RuntimeException("El cliente con este DNI ya está registrado"));

        mockMvc.perform(post("/api/v1/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void login_DebeRetornarOk() throws Exception {

        AuthLoginRequest request = new AuthLoginRequest();
        request.setEmail("test@uni.edu.pe");
        request.setPassword("123456");

        ClienteResponse response = ClienteResponse.builder()
                .idCliente("1")
                .nombre("Dhemiz")
                .email("test@uni.edu.pe")
                .build();

        when(clienteService.login(request))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/cliente/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCliente").value("1"))
                .andExpect(jsonPath("$.nombre").value("Dhemiz"));
    }

    @Test
    void login_DebeRetornarUnauthorized() throws Exception {

        AuthLoginRequest request = new AuthLoginRequest();
        request.setEmail("test@uni.edu.pe");
        request.setPassword("123456");

        when(clienteService.login(request))
                .thenThrow(new RuntimeException("Credenciales invalidas"));

        mockMvc.perform(post("/api/v1/cliente/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void obtenerClientes_DebeRetornarLista() throws Exception {

        ClienteResponse cliente = ClienteResponse.builder()
                .idCliente("1")
                .nombre("Dhemiz")
                .email("test@uni.edu.pe")
                .build();

        when(clienteService.obtenerClientes())
                .thenReturn(List.of(cliente));

        mockMvc.perform(get("/api/v1/cliente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idCliente").value("1"))
                .andExpect(jsonPath("$[0].nombre").value("Dhemiz"));
    }
}