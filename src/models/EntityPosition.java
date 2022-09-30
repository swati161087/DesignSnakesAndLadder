package models;

import enums.EntityType;
import models.entity.Entity;

public class EntityPosition {
    private EntityType entityType;
    private int cellPosition;
    private int power;

    public EntityPosition(EntityType entityType, int cellPosition,int power) {
        this.entityType = entityType;
        this.cellPosition = cellPosition;
        this.power=power;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public int getPower() {
        return power;
    }

    public int getCellPosition() {
        return cellPosition;
    }

}
