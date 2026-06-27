package org.streamvault.repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repositorio<T> {
    private final List<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    public List<T> obtenerTodos() {
        return new ArrayList<>(elementos);
    }

    public List<T> filtrar(Predicate<T> criterio) {
        return elementos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    public List<T> ordenar(Comparator<T> criterio) {
        return elementos.stream()
                .sorted(criterio)
                .collect(Collectors.toList());
    }

    public Optional<T> buscar(Predicate<T> criterio) {
        return elementos.stream()
                .filter(criterio)
                .findFirst();
    }
}