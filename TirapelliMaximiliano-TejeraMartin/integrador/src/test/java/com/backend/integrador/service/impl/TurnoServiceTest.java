package com.backend.integrador.service.impl;

import com.backend.integrador.dto.OdontologoDto;
import com.backend.integrador.dto.PacienteDto;
import com.backend.integrador.dto.TurnoDto;
import com.backend.integrador.entity.Domicilio;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.entity.Paciente;
import com.backend.integrador.entity.Turno;
import com.backend.integrador.exceptions.BadRequestException;
import com.backend.integrador.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    private static Paciente paciente;
    private static Odontologo odontologo;

    @BeforeAll
    public static void init(){
        paciente = new Paciente("martin", "tejera", "45632152", LocalDate.of(2023, 07, 12), new
                Domicilio("calle", 1, "Localidad", "Provincia"));
        odontologo = new Odontologo("SA-57468676", "Jorge", "Lopez");
    }

    @Test
    @Order(1)
    void deberiaInsertarUnTurno() throws BadRequestException {
        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        OdontologoDto odontologoDto = odontologoService.registrarOdontologo(odontologo);

        TurnoDto turnoDto = turnoService.guardarTurno(new Turno(paciente, odontologo, LocalDateTime.of(LocalDate.of(2023, 10 ,12), LocalTime.of(15,10))));

        Assertions.assertNotNull(turnoDto);
        Assertions.assertNotNull(turnoDto.getId());
        Assertions.assertEquals(turnoDto.getPaciente(), pacienteDto.getNombre() + " " + pacienteDto.getApellido());
        Assertions.assertEquals(turnoDto.getOdontologo(), odontologoDto.getNombre() + " " + odontologoDto.getApellido());

    }
    @Test
    @Order(2)
    void deberiaEliminarElTurno() throws ResourceNotFoundException {
        turnoService.eliminarTurno(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(1L));
    }

    @Test
    @Order(3)
    void deberiaRetornarListaVacia() {
        List<TurnoDto> turnoDtos = turnoService.listarTodos();
        Assertions.assertTrue(turnoDtos.isEmpty());
    }


}