package models;

import models.entity.Entity;

public class EntityPower {
    private Entity entity;
    private int steps;

    public EntityPower(Entity entity, int steps) {
        this.entity = entity;
        this.steps=steps;
    }

    public Entity getEntity() {
        return entity;
    }
    public int getSteps() {
        return steps;
    }
}
