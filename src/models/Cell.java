package models;

import models.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int position;
    private List<Symbol> symbols;
    private Entity entity;
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
    public Entity getEntity(){
        return this.entity;
    }
    public Entity setEntity(Entity entity) {
        this.entity = entity;
        return entity;
    }
}
