package com.ecomarket.user_service.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false, unique = true)
  private String correo;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Integer edad;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"))
  @Column(name = "rol")
  private List<String> roles = new ArrayList<>();

}
