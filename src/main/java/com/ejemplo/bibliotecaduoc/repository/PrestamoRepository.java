package com.ejemplo.bibliotecaduoc.repository;

import com.ejemplo.bibliotecaduoc.model.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {

    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public List<Prestamo> obtenerPrestamos() {
        return listaPrestamos;
    }

    public Prestamo buscarPorId(int id) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId_prestamo() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public Prestamo guardar(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
        return prestamo;
    }

    public Prestamo actualizar(int id, Prestamo prestamoActualizado) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getId_prestamo() == id) {
                listaPrestamos.set(i, prestamoActualizado);
                return prestamoActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(int id) {
        return listaPrestamos.removeIf(prestamo -> prestamo.getId_prestamo() == id);
    }
}