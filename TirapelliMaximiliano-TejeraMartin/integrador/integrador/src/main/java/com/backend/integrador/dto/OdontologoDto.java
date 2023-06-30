package com.backend.integrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto {

    private Long id;
    private String matricula;
    private String nombre;
    private String apellido;
    private DomicilioDto domicilioDto;

    public OdontologoDto() {
    }

    public OdontologoDto(Long id, String matricula, String nombre, String apellido,DomicilioDto domicilioDto) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilioDto = domicilioDto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public DomicilioDto getDomicilioDto() {
        return domicilioDto;
    }

    public void setDomicilioDto(DomicilioDto domicilioDto) {
        this.domicilioDto = domicilioDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
