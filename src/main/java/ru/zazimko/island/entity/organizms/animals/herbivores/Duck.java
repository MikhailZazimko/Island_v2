package ru.zazimko.island.entity.organizms.animals.herbivores;
import ru.zazimko.island.abstraction.annotations.TypeData;
import ru.zazimko.island.entity.organizms.Limit;

@TypeData(name = "Утка", icon = "\uD83E\uDD86", maxWeight = 1, maxCountInCell = 200, maxSpeed = 4, maxFood = 0.15)
public class Duck extends Herbivore {
    public Duck(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
