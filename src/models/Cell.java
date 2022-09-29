package models;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int position;
    List<Symbol> symbols;
    EntityPower entityPower;
    public Cell(int position) {
        this.position = position;
        this.symbols=new ArrayList<>();
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public void addSymbol(Symbol symbol){
        this.symbols.add(symbol);
    }

    public int getPosition() {
        return position;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }
    public void removeSymbol(Symbol symbol){
        this.symbols.remove(symbol);
    }
    public EntityPower getEntityPower(){
        return this.entityPower;
    }

    public void setEntityPower(EntityPower entityPower) {
        this.entityPower = entityPower;
    }
}
