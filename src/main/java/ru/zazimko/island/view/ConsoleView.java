package ru.zazimko.island.view;
import ru.zazimko.island.entity.map.Cell;
import ru.zazimko.island.entity.map.GameMap;
import ru.zazimko.island.entity.map.Residents;

import java.util.*;


@SuppressWarnings("FieldCanBeLocal")
public class ConsoleView implements View {

    private final GameMap gameMap;

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;

    }


    @Override
    public void showStatistics() {
        Map<String, Double> rawStatistics = new HashMap<>();
        Map<String, Long> statistics = new HashMap<>();
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Residents residents = cell.getResidents();
                if (Objects.nonNull(residents)) {
                    residents.values().stream()
                            .filter(organisms -> organisms.size() > 0)
                            .forEach(organisms -> {
                                        String icon = organisms.getIcon();
                                        double count = organisms.calculateSize();
                                        rawStatistics.put(icon, rawStatistics.getOrDefault(icon, 0D) + count);
                                    }
                            );
                }
            }
        }
        rawStatistics.forEach((key, value) -> statistics.put(key, Math.round(value)));
        System.out.println(statistics + "\n");

    }
}
