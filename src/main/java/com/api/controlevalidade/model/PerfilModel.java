package com.api.controlevalidade.model;

import com.api.controlevalidade.model.tiposEnuns.TipoPerfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbl_Perfil")
public class PerfilModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do perfil é obrigatório!")
    @Size(max = 50)
    @Column(name = "nome_perfil", nullable = false, length = 50)
    private String nomePerfil;

    @NotBlank(message = "Senha é obrigatória!")
    @Size(max = 100) // aumente o limite para suportar senhas criptografadas
    @Column(nullable = false, length = 100)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "empresa_id") // empresa pode ser nula para perfis ADMINISTRADOR
    private EmpresaModel empresa;

    @NotNull(message = "Tipo de perfil é obrigatório!")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_perfil", nullable = false, length = 20)
    private TipoPerfil tipoPerfil;

    // Construtor padrão exigido pelo JPA
    public PerfilModel() {
    }

    //Construtor personalizado usado no controller
    public PerfilModel(String nomePerfil, String senha, TipoPerfil tipoPerfil) {
        this.nomePerfil = nomePerfil;
        this.senha = senha;
        this.tipoPerfil = tipoPerfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipoPerfil == TipoPerfil.ADMINISTRADOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"),
                    new SimpleGrantedAuthority("ROLE_USUARIO")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nomePerfil;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}