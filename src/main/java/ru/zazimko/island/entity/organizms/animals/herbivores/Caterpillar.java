package ru.zazimko.island.entity.organizms.animals.herbivores;


import ru.zazimko.island.abstraction.annotations.TypeData;
import ru.zazimko.island.entity.organizms.Limit;

@TypeData(name = "Гусеница", icon = "\uD83D\uDC1B", maxWeight =0.01, maxCountInCell = 1000, maxSpeed = 0, maxFood = 0)
public class Caterpillar extends Herbivore {
    public Caterpillar(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
