package models;

import enums.PlayerStatus;

public class Player {
    private String name;
    private int currentLocation;
    private PlayerStatus playerStatus;

    public String getName() {
        return name;
    }

    public Player(String name, Symbol symbol)
    {
        this.name=name;
        this.currentLocation=0;
        this.playerStatus=PlayerStatus.Locked;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public int getCurrentLocation(){
        return currentLocation;
    }

    public void makeMove(int steps,Board board){

        int newPosition=currentLocation+steps;
        if(newPosition>=board.getBoard().size())
        {
            System.out.println("Can not move");
            return;
        }
        else if(newPosition<0)
        {
            newPosition=0;
        }
        currentLocation=newPosition;
     }

     public void moveToLocation(int newCellPosition)
     {
         currentLocation=newCellPosition;
     }

}
