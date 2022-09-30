package models.entity;

import enums.EntityType;
import models.Cell;
import models.Symbol;

public abstract class Entity {

    private EntityType entityType;

    public Entity( EntityType entityType) {
        this.entityType = entityType;

    }
    public abstract int getPower();
}
