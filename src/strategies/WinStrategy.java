package strategies;

import models.Board;
import models.Player;
import models.Symbol;

public interface WinStrategy {
    boolean checkWin(Board board, Player player);
}
