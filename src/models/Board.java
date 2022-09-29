package models;

import enums.BoardType;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> board;
    private BoardType boardType;

    public List<Cell> getBoard() {
        return board;
    }


    public BoardType getBoardType() {
        return boardType;
    }

    private Board(int dimension){
        this.board=new ArrayList<>();
        for(int i=0;i<=dimension;i++)
        {
            this.board.add(new Cell(i));
        }
    }
    public static Builder getBoardBuilder(){
        return new Builder();
    }
    public static class Builder{
        private List<EntityPosition> entityPositions;
        private int dimension;

        public Builder() {
            this.entityPositions = new ArrayList<>();
        }

        public Builder addAllEntityPosition(List<EntityPosition> entityPositions){
            // validate entity position here as well
            this.entityPositions.addAll(entityPositions);
            return this;
        }
        public Builder setBoard(int dimension)
        {
            this.dimension=dimension;
            return this;
        }
        public Board build(){
            Board board=new Board(dimension);
            for(EntityPosition entityPosition : entityPositions){
                board.getBoard()
                        .get(entityPosition.getCellPosition())
                        .setEntityPower(new EntityPower(entityPosition.getEntity(),entityPosition.getPower()));
            }
            return board;
        }
    }
    public Cell getCell(int position)
    {
        return this.board.get(position);
    }

}
