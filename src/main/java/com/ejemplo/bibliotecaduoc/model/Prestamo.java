package com.ejemplo.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {

    private int id_prestamo;
    private int id_libro;
    private String run_solicitante;
    private String fecha_solicitud;
    private String fecha_entrega;
    private int cantidad_dias;
    private int multas;
}