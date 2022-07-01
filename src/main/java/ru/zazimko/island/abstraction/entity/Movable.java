package ru.zazimko.island.abstraction.entity;

import ru.zazimko.island.entity.map.Cell;

@FunctionalInterface
public interface Movable {

    @SuppressWarnings("UnusedReturnValue")
    boolean move(Cell startCell);

}
