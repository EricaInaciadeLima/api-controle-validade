package com.api.controlevalidade.controller;

import com.api.controlevalidade.config.security.TokenService;
import com.api.controlevalidade.exception.custom.CredenciaisInvalidasException;
import com.api.controlevalidade.model.EmpresaModel;
import com.api.controlevalidade.model.dto.LoginResponseDTO;
import com.api.controlevalidade.model.PerfilModel;
import com.api.controlevalidade.service.EmpresaService;
import com.api.controlevalidade.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    TokenService tokenService;
    @Autowired
    private PerfilService perfilService;


    @PostMapping("/cadastro")
    public ResponseEntity<String> criar(@Valid @RequestBody PerfilModel perfil) {
        if (perfilService.existsByNomePerfil(perfil.getNomePerfil())) {
            return ResponseEntity.badRequest().body("Perfil já existe!");
        }

        String encryptedPassword = passwordEncoder.encode(perfil.getSenha());
        PerfilModel novoPerfil = new PerfilModel(perfil.getNomePerfil(), encryptedPassword, perfil.getTipoPerfil());
        perfilService.save(novoPerfil);
        return ResponseEntity.status(HttpStatus.CREATED).body("Perfil criado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody PerfilModel login) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(
                    login.getNomePerfil(),
                    login.getSenha()
            );

            var authentication = authenticationManager.authenticate(usernamePassword);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = tokenService.generateToken(userDetails);

            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (BadCredentialsException ex) {
            throw new CredenciaisInvalidasException("Usuário ou senha inválidos. Verifique suas credenciais e tente novamente.");
        }
    }

    @PostMapping("/{empresaId}")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<String> criarPerfilParaEmpresa(
            @PathVariable Long empresaId,
            @Valid @RequestBody PerfilModel novoPerfil) {

        EmpresaModel empresa = empresaService.buscarPorId(empresaId);
        novoPerfil.setEmpresa(empresa);

        String senhaCriptografada = passwordEncoder.encode(novoPerfil.getSenha());
        novoPerfil.setSenha(senhaCriptografada);

        perfilService.save(novoPerfil);
        return ResponseEntity.status(HttpStatus.CREATED).body("Perfil criado para a empresa com sucesso!");
    }

}