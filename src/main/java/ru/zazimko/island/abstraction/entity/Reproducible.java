package ru.zazimko.island.abstraction.entity;

import ru.zazimko.island.entity.map.Cell;

@FunctionalInterface
public interface Reproducible {

    @SuppressWarnings("UnusedReturnValue")
    boolean spawn(Cell currentCell);

}
