package ru.zazimko.island.entity.organizms.animals.predators;
import ru.zazimko.island.abstraction.annotations.TypeData;
import ru.zazimko.island.entity.organizms.Limit;

@TypeData(name = "Орел", icon = "\uD83E\uDD85", maxWeight = 6, maxCountInCell = 20, maxSpeed = 3, maxFood = 1)
public class Eagle extends Predator {


    public Eagle(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
