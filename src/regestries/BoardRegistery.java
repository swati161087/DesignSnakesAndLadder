package regestries;

import enums.BoardType;
import models.Board;

import java.util.HashMap;

public class BoardRegistery {
    private HashMap<BoardType, Board> boardHashMap;
    public BoardRegistery(){
        this.boardHashMap=new HashMap<>();
    }
    public void addBoard(BoardType boardType,Board board){
        this.boardHashMap.put(boardType,board);
    }
    public Board getBoard(BoardType boardType)
    {
        return this.boardHashMap.get(boardType);
    }
}
