package com.ejemplo.bibliotecaduoc.controller;

import com.ejemplo.bibliotecaduoc.model.Prestamo;
import com.ejemplo.bibliotecaduoc.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class PrestamoController {

    @Autowired
    private PrestamoService service;

    @GetMapping
    public List<Prestamo> obtenerPrestamos() {
        return service.obtenerPrestamos();
    }

    @GetMapping("/ordenados")
    public List<Prestamo> obtenerPrestamosOrdenados() {
        return service.obtenerPrestamosOrdenados();
    }

    @GetMapping("/{id}")
    public Prestamo buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Prestamo guardar(@RequestBody Prestamo prestamo) {
        return service.guardar(prestamo);
    }

    @PutMapping("/{id}")
    public Prestamo actualizar(@PathVariable int id, @RequestBody Prestamo prestamo) {
        return service.actualizar(id, prestamo);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return service.eliminar(id);
    }
}