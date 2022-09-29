package models;

import models.entity.Entity;

public class EntityPosition {
    private Entity entity;
    private int cellPosition;
   private int power;

    public EntityPosition(Entity entity, int cellPosition, int power) {
        this.entity = entity;
        this.cellPosition = cellPosition;
        this.power = power;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getCellPosition() {
        return cellPosition;
    }

    public int getPower() {
        return power;
    }
}
