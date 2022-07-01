package ru.zazimko.island.entity.organizms.animals.herbivores;
import ru.zazimko.island.abstraction.annotations.TypeData;
import ru.zazimko.island.entity.organizms.Limit;

@TypeData(name = "Буйвол", icon = "\uD83D\uDC03", maxWeight = 700 , maxCountInCell = 10, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivore {
    public Buffalo(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
