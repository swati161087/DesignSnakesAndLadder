package strategies;

import models.Board;
import models.Player;
import models.Symbol;

public class FirstPersonWinStrategy implements WinStrategy{
    @Override
    public boolean checkWin(Board board,  Player player) {
        int maxNumber=board.getBoard().size()-1;
        if(player.getCurrentPosition().getPosition()==maxNumber){
            return true;
        }
        return false;
    }
}
