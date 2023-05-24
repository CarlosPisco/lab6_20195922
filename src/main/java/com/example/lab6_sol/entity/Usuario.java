package com.example.lab6_sol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Size(max=100,message="El nombre no puede tener mas de 100 caracteres")
    @Size(min=3,message="El nombre no puede tener menos de 3 caracteres")
    @Column(nullable = false)
    @NotBlank
    private String nombres;

    @Size(max=100,message="El apellido no puede tener mas de 100 caracteres")
    @Size(min=3,message="El apellido no puede tener menos de 3 caracteres")
    @Column(nullable = false)
    @NotBlank
    private String apellidos;


    @Size(max=8,message="El dni tiene 8 caracterees")
    @Size(min=8,message="El dni tiene 8 caracterees")
    @Column(nullable = false)
    @NotBlank
    private String dni;


    @Min(value=0)
    @Column(nullable = false)
    @NotBlank
    private int edad;


    @Column(nullable = false)
    @NotBlank
    private String correo;


    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private int rolid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}