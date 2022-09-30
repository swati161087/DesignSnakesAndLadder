package models.entity;

import enums.EntityType;
import models.Cell;
import models.Symbol;

public abstract class Entity {

    private EntityType entityType;
    private int power;
    public Entity( EntityType entityType,int power) {
        this.entityType = entityType;
        this.power=power;
    }
    public int getPower() {
        return power;
    }
}
