package models;

import enums.BoardType;
import enums.GameStatus;
import enums.PlayerStatus;
import models.entity.Entity;
import regestries.BoardRegistery;
import strategies.StartStrategy;
import strategies.StartWithOneAndSixStrategy;
import strategies.WinStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;
    private Player winner;
    private GameStatus gameStatus;
    private int lastPlayerIndex;
    private List<WinStrategy> winStrategies;
    private StartStrategy startStrategy;
    private Game(){
        this.winStrategies=new ArrayList<>();
        this.players=new ArrayList<>();
        this.lastPlayerIndex=-1;
        this.gameStatus=GameStatus.Running;
        startStrategy=new StartWithOneAndSixStrategy();
    }
    public static Builder createGame(){
        return new Builder();
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void makeMove(){

        int totalPlayers=this.players.size();
        int sizeOfBoard=this.board.getBoard().size();
        this.lastPlayerIndex++;
        lastPlayerIndex%=totalPlayers;
        Player currentPlayer=this.players.get(lastPlayerIndex);
        System.out.println(currentPlayer.getName()+ " make move");
        Scanner myObj = new Scanner(System.in);
        myObj.next();

        int countSix=2;
        int steps=this.dice.rollDice();
        System.out.println(currentPlayer.getName()+ " got " + steps);
        if(steps==6){
           for(int i=1;i<=countSix;i++)
           {
               int val=this.dice.rollDice();
               steps+=val;
               System.out.println("got " + val);
               if(val!=6) break;
           }
           if(steps==18) steps=6;
           System.out.println("you now have " +steps);
        }
        if(currentPlayer.getPlayerStatus().equals(PlayerStatus.Locked) && this.startStrategy.canStart(steps)){
            currentPlayer.setPlayerStatus(PlayerStatus.Playing);
        } else if (currentPlayer.getPlayerStatus().equals(PlayerStatus.Locked)) {
            return;
        }
        currentPlayer.makeMove(steps,this.board);
        int currentLocation=currentPlayer.getCurrentLocation();
        Entity entity =board.getBoard().get(currentLocation).getEntity();
        if(entity !=null){
            int newSteps=entity.getPower();
            if(newSteps<0) System.out.println("oops cut by snake u are going down by " +newSteps);
            else System.out.println("wow got a ladder going up by " +newSteps);
            currentPlayer.makeMove(newSteps,board);

        }
        System.out.println("You are now at " +currentPlayer.getCurrentLocation());
        for(WinStrategy winStrategy:winStrategies){
            if(winStrategy.checkWin(board,currentPlayer))
            {
                gameStatus=GameStatus.Won;
                winner=currentPlayer;
                currentPlayer.setPlayerStatus(PlayerStatus.Won);
                break;
            }
        }
    }
    public static class Builder{
        private BoardType boardType;
        private List<Player> players;
        private int diceSize;
        private List<WinStrategy> winStrategies;
        private BoardRegistery boardRegistery;
        Builder(){
            this.winStrategies=new ArrayList<>();
            this.players=new ArrayList<>();
        }
        public Builder setBoardType(BoardType boardType) {
            this.boardType = boardType;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }

        public Builder setDiceSize(int diceSize) {
            this.diceSize = diceSize;
            return this;
        }

        public Builder setWinStrategies(List<WinStrategy> winStrategies) {
            this.winStrategies.addAll(winStrategies);
            return this;
        }
        public Builder setBoardRegistery(BoardRegistery boardRegistery)
        {
            this.boardRegistery=boardRegistery;
            return this;
        }
        public Game build(){
            Game game=new Game();
           game.board= this.boardRegistery.getBoard(this.boardType);
           game.players=this.players;
           game.winStrategies=this.winStrategies;
           game.dice=new Dice(diceSize);
           return game;
        }
    }

}
