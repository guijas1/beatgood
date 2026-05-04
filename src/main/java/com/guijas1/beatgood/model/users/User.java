package com.guijas1.beatgood.model.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    @Pattern(regexp = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$/\n",
    message = "")
    private String passwordHash;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleUsers roleUsers;

    @Column(name = "create_at")
    private OffsetDateTime createAt = OffsetDateTime.now();
}
