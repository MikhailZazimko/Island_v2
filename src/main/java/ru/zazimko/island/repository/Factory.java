package ru.zazimko.island.repository;

import ru.zazimko.island.entity.map.Cell;
import ru.zazimko.island.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell(boolean empty);

    List<Organism> getAllPrototypes();

}
