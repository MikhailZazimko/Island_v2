package ru.zazimko.island.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.zazimko.island.entity.map.GameMap;
import ru.zazimko.island.repository.Factory;
import ru.zazimko.island.view.View;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;

}
