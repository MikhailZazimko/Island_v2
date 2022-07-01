package ru.zazimko.island.entity.organizms.animals;
import ru.zazimko.island.abstraction.entity.Eating;
import ru.zazimko.island.abstraction.entity.Movable;
import ru.zazimko.island.abstraction.entity.Reproducible;
import ru.zazimko.island.config.Setting;
import ru.zazimko.island.entity.map.Cell;
import ru.zazimko.island.entity.organizms.Limit;
import ru.zazimko.island.entity.organizms.Organism;
import ru.zazimko.island.entity.organizms.Organisms;

public abstract class Animal extends Organism implements Eating, Reproducible, Movable {

    public Animal(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }


    public boolean eat(Cell currentCell) {
        if (safeFindFood(currentCell)) {
            return true;
        }
        if (getWeight() > 0) {
            return safeChangeWeight(currentCell, -1 * Setting.get().getPercentAnimalSlim());
        }
        return !safeDie(currentCell);
    }
       public boolean move(Cell startCell) {
        int countStep = this
                .getLimit()
                .getMaxSpeed();
        Cell destinationCell = startCell.getNextCell(countStep);
        return safeMove(startCell, destinationCell);
    }

    @Override
    public boolean spawn(Cell cell) {
        return safeSpawnAnimal(cell);
    }

    private boolean safeSpawnAnimal(Cell cell) {
        cell.getLock().lock();
        try {
            Organisms organisms = cell.getResidents().get(getType());
            double maxWeight = getLimit().getMaxWeight();
            if (getWeight() > maxWeight / 2 &&
                    organisms.contains(this) &&
                    (organisms.getLimit().getFlockSize() > 1 || organisms.size() >= 2) &&
                    organisms.size() < getLimit().getMaxCountInCell()
            ) {
                //all animals lose weight after the birth of offspring
                double childWeight = getWeight() / 2;
                setWeight(childWeight / 2);
                Organism clone = Organism.clone(this);
                clone.setWeight(childWeight);
                organisms.add(clone);
                return true;
            }
        } finally {
            cell.getLock().unlock();
        }
        return false;
    }


}
