package com.ecomarket.user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique=true, length = 13, nullable = false)
  private String run;

  @Column(nullable=false)
  private String nombre;

  @Column(nullable=false)
  private String apellido;

  @Column(nullable=false)
  private String correo;

  



}
