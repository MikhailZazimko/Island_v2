package ru.zazimko.island;
import ru.zazimko.island.config.Setting;
import ru.zazimko.island.entity.Game;
import ru.zazimko.island.entity.map.GameMap;
import ru.zazimko.island.repository.AnimalFactory;
import ru.zazimko.island.repository.Factory;
import ru.zazimko.island.repository.GameMapCreator;
import ru.zazimko.island.services.GameWorker;
import ru.zazimko.island.view.ConsoleView;
import ru.zazimko.island.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        Factory entityFactory = new AnimalFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        int rows = Setting.get().getRows();
        int cols = Setting.get().getCols();
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(rows, cols, false);
        View view=new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory,view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
