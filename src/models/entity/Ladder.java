package models.entity;

import enums.EntityType;
import models.Cell;
import models.Symbol;

public class Ladder extends Entity{
    public Ladder(int power){
        super(EntityType.Ladder,power);
    }

}
