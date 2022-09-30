package models.entity;

import enums.EntityType;
import models.Cell;
import models.Symbol;

public class Snake extends Entity{
    public Snake(int power){
        super(EntityType.Snake,power);
    }

}
