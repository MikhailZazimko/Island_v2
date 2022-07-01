package ru.zazimko.island.view;
import ru.zazimko.island.config.Setting;
import ru.zazimko.island.entity.map.Cell;
import ru.zazimko.island.entity.map.GameMap;
import ru.zazimko.island.entity.map.Residents;
import ru.zazimko.island.entity.organizms.Organism;
import ru.zazimko.island.entity.organizms.Organisms;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SuppressWarnings("FieldCanBeLocal")
public class ConsoleView implements View {

    private final int showRows;
    private final int showCols;
    private int rows;
    private int cols;
    private final boolean cutRows;
    private final boolean cutCols;

    private final GameMap gameMap;
    private final int cellWidth = Setting.get().getConsoleCellWith();
    private final String border = "═".repeat(cellWidth);

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;

        showRows = Setting.get().getShowRows();
        rows = gameMap.getRows();
        cutRows = rows > showRows;
        rows = cutRows ? showRows : rows;

        showCols = Setting.get().getShowCols();
        cols = gameMap.getCols();
        cutCols = cols > showCols;
        cols = cutCols ? showCols : cols;
    }


    @Override
    public String showStatistics() {
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
        return statistics.toString();
    }
    public void printInfo(){
        int totalCount = 0;
        Cell[][] cells = gameMap.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Residents residents = cells[i][j].getResidents();
                for (Organisms value : residents.values()) {
                        totalCount++;
                    }
                }
            }
        System.out.println("Общее количество организмов: " + totalCount);
    }
}
