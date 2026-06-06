package com.ejemplo.bibliotecaduoc.service;

import com.ejemplo.bibliotecaduoc.model.Prestamo;
import com.ejemplo.bibliotecaduoc.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository repository;

    public List<Prestamo> obtenerPrestamos() {
        return repository.obtenerPrestamos();
    }

    public List<Prestamo> obtenerPrestamosOrdenados() {
        return repository.obtenerPrestamos()
                .stream()
                .sorted(Comparator.comparingInt(Prestamo::getId_prestamo))
                .toList();
    }

    public Prestamo buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public Prestamo guardar(Prestamo prestamo) {
    if (prestamo.getRun_solicitante() == null || prestamo.getRun_solicitante().trim().isEmpty()) {
        throw new IllegalArgumentException("El RUN del solicitante no puede estar vacío");
    }
    return repository.guardar(prestamo);
}

public Prestamo actualizar(int id, Prestamo prestamo) {
    prestamo.setId_prestamo(id);
    return repository.actualizar(id, prestamo);
}

    public boolean eliminar(int id) {
        return repository.eliminar(id);
    }
}