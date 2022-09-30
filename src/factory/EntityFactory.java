package factory;

import enums.EntityType;
import models.entity.Entity;
import models.entity.Ladder;
import models.entity.Snake;

public class EntityFactory {
    public static Entity getEntity(EntityType entityType,int power){
        return switch (entityType){
            case Snake,Frog -> new Snake(power);
            case Ladder -> new Ladder(power);
            default -> throw new RuntimeException("Entity Not found"+entityType);
        };
    }
}
