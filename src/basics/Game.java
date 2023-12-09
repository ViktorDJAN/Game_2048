package basics;

import basics.Direction;
import boards.Board;

public interface Game {
    /** The game start */
    void init();

     /** Checking for next game step ability */
    boolean canMove();

    /** A new game step to the specified direction */
    void move(Direction direction);

    /** A new item addition */
    void addItem();

    /** Getting of the play board */
    Board getGameBoard();

    /** Victory expecting method  */
    boolean hasWin();
}
