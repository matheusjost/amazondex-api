package br.unisc.amazondex.security;

import br.unisc.amazondex.controller.ResponseHandler;
import br.unisc.amazondex.entity.Usuario;
import br.unisc.amazondex.exception.AmazondexException;
import br.unisc.amazondex.pojo.ApiResponseDTO;
import br.unisc.amazondex.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    @Operation(description = "Método referente ao login de usuário.")
    @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso", content = @Content)
    @ApiResponse(responseCode = "401", description = "Usuário ou senha inválidos", content = @Content)
    @PostMapping
    public ResponseEntity<ApiResponseDTO> login(@RequestBody LoginDTO dto){
        try {
            if (validateLoginDTO(dto)) throw new AmazondexException("Usuário ou senha inválidos");

            var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var principal = (Usuario) auth.getPrincipal();
            var token = tokenService.generateToken(principal);
            return ResponseEntity.ok(ApiResponseDTO.okApiResponse(new LoginResponseDTO(principal.getId(), token, principal.getRole(), principal.getLogin())));
        } catch (AmazondexException e) {
            return ResponseHandler.errorApiResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Operation(description = "Método referente ao registro de usuário.")
    @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já existe")
    @SecurityRequirement(name = "Bearer", scopes = "admin")
    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO> register(@RequestBody RegisterDTO dto) {
        try {
            validateUserRegister(dto, null);

            String encodedPassword = new BCryptPasswordEncoder().encode(dto.senha());

            Usuario usr = new Usuario(dto.login(), encodedPassword, dto.nome(), dto.email(), dto.role());
            Usuario newUser = usuarioRepository.save(usr);

            return ResponseHandler.createdApiResponse(newUser.getId());
        } catch (AmazondexException e) {
            return ResponseHandler.errorApiResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Operation(description = "Método referente ao registro de usuário.")
    @ApiResponse(responseCode = "201", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já existe")
    @ApiResponse(responseCode = "500", description = "Erro ao atualizar usuário")
    @SecurityRequirement(name = "Bearer", scopes = "admin")
    @PutMapping("/register/{id}")
    public ResponseEntity<ApiResponseDTO> update(@PathVariable Integer id, @RequestBody RegisterDTO dto) {
        try {
            validateUserRegister(dto, id);

            String encodedPassword = new BCryptPasswordEncoder().encode(dto.senha());

            Usuario usr = new Usuario(id, dto.login(), encodedPassword, dto.nome(), dto.email(), dto.role());
            Usuario newUser = usuarioRepository.save(usr);

            return ResponseHandler.createdApiResponse(newUser.getId());
        } catch (AmazondexException e) {
            return ResponseHandler.errorApiResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.errorApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    private void validateUserRegister(RegisterDTO dto, Integer id) throws AmazondexException {
        if (validateRegisterDTO(dto)) throw new AmazondexException("Usuário inválido");
        if (id == null && validateUniqueUser(dto)) throw new AmazondexException("Usuário já existe");
    }

    private boolean validateLoginDTO(LoginDTO dto) {
        return dto.login() == null || dto.senha() == null;
    }

    private boolean validateRegisterDTO(RegisterDTO dto) {
        return dto.login() == null || dto.senha() == null || dto.email() == null || dto.nome() == null || dto.role() == null;
    }

    private boolean validateUniqueUser(RegisterDTO dto) {
        return usuarioRepository.findByEmail(dto.email()) != null || usuarioRepository.findByLogin(dto.login()) != null;
    }

}
