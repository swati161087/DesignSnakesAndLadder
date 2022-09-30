package models.entity;

import enums.EntityType;
import models.Cell;
import models.Symbol;

public class Ladder extends Entity{
    private int power;
    public Ladder(int power){
        super(EntityType.Ladder);
        this.power=power;
    }

    @Override
    public int getPower() {
        return this.power;
    }
}
