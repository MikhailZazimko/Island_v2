package ru.zazimko.island.entity.organizms.animals.predators;
import ru.zazimko.island.abstraction.annotations.TypeData;
import ru.zazimko.island.entity.organizms.Limit;

@TypeData(name = "Медведь", icon = "\uD83D\uDC3B", maxWeight = 500, maxCountInCell = 5, maxSpeed = 2, maxFood = 80)
public class Bear extends Predator {

    public Bear(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
