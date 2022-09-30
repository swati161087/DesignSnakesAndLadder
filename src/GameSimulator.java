import controllers.GameController;
import enums.BoardType;
import enums.GameStatus;
import models.Game;
import models.Player;
import models.Symbol;
import regestries.BoardRegistery;
import strategies.FirstPersonWinStrategy;
import strategies.WinStrategy;

import java.util.List;
import java.util.Scanner;

public class GameSimulator {
    public static void main(String[] args) {
        GameController gameController=new GameController();
        BoardRegistery boardRegistery=gameController.createBoard();
        Player player1=new Player("Swati",new Symbol('X'));
        Player player2=new Player("Anika",new Symbol('Y'));
        WinStrategy winStrategy=new FirstPersonWinStrategy();
        Game game=gameController.createGame(boardRegistery, BoardType.StandardSizeBoard, List.of(player1,player2),List.of(winStrategy));
        while (game.getGameStatus().equals(GameStatus.Running)){

            game.makeMove();
        }
        System.out.println("Game is won "+game.getGameStatus() +" by  "+game.getWinner().getName());
    }
}
