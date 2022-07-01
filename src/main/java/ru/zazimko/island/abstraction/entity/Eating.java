package ru.zazimko.island.abstraction.entity;

import ru.zazimko.island.entity.map.Cell;

@FunctionalInterface
public interface Eating {

    boolean eat(Cell currentCell);

}
