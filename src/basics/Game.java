package basics;

import boards.Board;
import exceptions.NotEnoughSpace;

public interface Game {
    /** The game start */
    void init();
    /** Checking for next game step ability */
    boolean canMove();
    /** A new game step to the specified direction */
    boolean move(Direction direction);
    /** A new item addition */
    void addItem() throws NotEnoughSpace;
    /** Getting of the play board */
    Board getGameBoard();
    /** Victory expecting method  */
    boolean hasWin();
}
