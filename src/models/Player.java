package models;

public class Player {
    private String name;
    private Cell currentPosition;
    private Symbol symbol;

    public String getName() {
        return name;
    }

    public Player(String name, Symbol symbol)
    {
        this.name=name;
        this.symbol=symbol;
    }
    public void addPlayerToGame(Board board){
        this.currentPosition=board.getCell(0);
        this.currentPosition.addSymbol(this.symbol);
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void makeMove(int steps,Board board){

        int currentCellLocation=currentPosition.getPosition();
        int newPosition=currentCellLocation+steps;
        if(newPosition>=board.getBoard().size())
        {
            System.out.println("Can not move");
            return;
        }
        else if(newPosition<0)
        {
            newPosition=0;
        }
        currentPosition.removeSymbol(this.symbol);

        this.currentPosition=board.getCell(newPosition);
        this.currentPosition.addSymbol(this.symbol);
     }

     public void moveToLocation(Cell newCellPosition)
     {
         int currentCellLocation=currentPosition.getPosition();
         currentPosition.removeSymbol(this.symbol);
         currentPosition=newCellPosition;
     }
}
