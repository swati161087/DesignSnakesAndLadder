package models;

import models.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int position;
    private Entity entity;
    public Cell(int position) {
        this.position = position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    public Entity getEntity(){
        return this.entity;
    }
    public Entity setEntity(Entity entity) {
        this.entity = entity;
        return entity;
    }
}
