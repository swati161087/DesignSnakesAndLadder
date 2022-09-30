package models.entity;

import enums.EntityType;
import models.Cell;
import models.Symbol;

public class Snake extends Entity{
    private int power;
    public Snake(int power){
        super(EntityType.Snake);
        this.power=power;
    }
    @Override
    public int getPower() {
        return this.power;
    }
}
