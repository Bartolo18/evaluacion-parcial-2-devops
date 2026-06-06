package com.ejemplo.bibliotecaduoc.repository;

import com.ejemplo.bibliotecaduoc.model.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {

    private List<Prestamo> listaPrestamos = new ArrayList<>(
            List.of(
                    new Prestamo(1, 1, "1", "2024-01-01", "2024-01-15", 14, 0

                    ),
                    new Prestamo(2, 2, "2", "2024-02-01", "2024-02-15", 14, 0   )
            )   
    );

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