package controllers;

import enums.BoardType;
import enums.EntityType;
import enums.GameStatus;
import models.*;
import models.entity.Entity;
import models.entity.Ladder;
import models.entity.Snake;
import regestries.BoardRegistery;
import strategies.WinStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public BoardRegistery createBoard(){
        List<EntityPosition>entityPositions=new ArrayList<>();
        entityPositions.add(new EntityPosition(new Snake(),32,-22));
        entityPositions.add(new EntityPosition(new Snake(),36,-30));
        entityPositions.add(new EntityPosition(new Snake(),48,-26));
        entityPositions.add(new EntityPosition(new Snake(),63,-45));
        entityPositions.add(new EntityPosition(new Snake(),88,-24));
        entityPositions.add(new EntityPosition(new Snake(),95,-39));
        entityPositions.add(new EntityPosition(new Snake(),97,-19));
        entityPositions.add(new EntityPosition(new Ladder(),1,37));
        entityPositions.add(new EntityPosition(new Ladder(),4,10));
        entityPositions.add(new EntityPosition(new Ladder(),20,12));
        entityPositions.add(new EntityPosition(new Ladder(),28,76));
        entityPositions.add(new EntityPosition(new Ladder(),50,17));
        entityPositions.add(new EntityPosition(new Ladder(),71,21));
        entityPositions.add(new EntityPosition(new Ladder(),88,11));


        Board board=Board.getBoardBuilder()
                .setBoard(100)
                .addAllEntityPosition(entityPositions)
                .build();
        BoardRegistery boardRegistery =new BoardRegistery();
        boardRegistery.addBoard(BoardType.StandardSizeBoard,board);
        return boardRegistery;
    }
    public Game createGame(BoardRegistery boardRegistery, BoardType boardType, List<Player> players, List<WinStrategy>winStrategies){
        Game game=Game.createGame()
                .setBoardRegistery(boardRegistery)
                .setBoardType(boardType)
                .setDiceSize(6)
                .setPlayers(players)
                .setWinStrategies(winStrategies)
                .build();
        return game;
    }
    public void makeMove(Game game){
        game.makeMove();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }

}
