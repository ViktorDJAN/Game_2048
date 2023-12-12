package basics;

import basics.Direction;
import basics.Game;
import basics.GameHelper;
import boards.Board;
import boards.SquareBoard;
import key.Key;

import java.util.ArrayList;
import java.util.Random;

public class Game2048 implements Game {
    GameHelper helper = new GameHelper();
    Board board;
    Random random = new Random();

    public static final  int GAME_SIZE = 4;
    private final Board<Key,Integer>  filledBoard= new SquareBoard<>(GAME_SIZE);

    // might be better if it is empty
        public Game2048() {
        }
//    public Game2048(Board board) {
//        this.board = board;
//    }

    ArrayList<Integer> attemptList = new ArrayList<>();

    @Override
    public void init() {
        board.fillBoard(attemptList);
    }

    @Override
    public boolean canMove() {
        if (board.availableSpace().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case UP:
                for (int i = 0; i < board.getHeight(); i++) {
                    helper.moveAndMergeEqual(board.getColumnValues(i));
                }
                break;
            case DOWN:
                for (int i = board.getHeight(); i > 0; i--) {
                    helper.moveAndMergeEqual(board.getColumnValues(i));
                }
                break;
            case LEFT:
                for (int i = 0; i < board.getWidth(); i++) {
                    helper.moveAndMergeEqual(board.getRowValues(i));
                }
                break;
            case RIGHT:
                for (int i = board.getWidth(); i > 0; i--) {
                    helper.moveAndMergeEqual(board.getRowValues(i));
                }
                break;
        }
    }



    @Override
    public void addItem() {
        Random random1 = new Random();
         var unfilledCells  = board.availableSpace();
         for(var certainKey: unfilledCells){
             board.addItem(certainKey, random1.nextInt(16));
         }

    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        if(board.hasValue(2048)){
            return true;
        }
        return false;
    }
}
