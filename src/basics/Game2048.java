package basics;

import boards.Board;
import boards.SquareBoard;
import exceptions.NotEnoughSpace;
import key.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Collections.reverse;

public class Game2048 implements Game {
    GameHelper helper = new GameHelper();
    Random random = new Random();
    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);




    public Game2048() {
    }

    @Override
    public void init() {
        new Game2048();
        board.fillBoard((Collections.nCopies(GAME_SIZE * GAME_SIZE, null)));
        addItem();

    }

    @Override
    public boolean canMove() {
        if (board.availableSpace().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean move(Direction direction) {
        var unchangeableBoard = new ArrayList<Integer>();
        var resultBoard = new ArrayList<Integer>();
        List<Key> keysList;
        List<Integer> exchangingRow;
        switch (direction) {
            case LEFT:
                for (int i = 0; i < board.getWidth(); i++) {
                    resultBoard.addAll(helper.moveAndMergeEqual(board.getValues(board.getRow(i))));
                }
                board.fillBoard(resultBoard);
                break;
            case RIGHT:
                for (int i = 0; i < board.getWidth(); i++) {
                    reverse(keysList = board.getRow(i));
                    exchangingRow = helper.moveAndMergeEqual(board.getValues(keysList));
                    reverse(exchangingRow);
                    resultBoard.addAll(exchangingRow);
                }
                board.fillBoard(resultBoard);
                break;
            case UP:
                for (int i = 0; i < board.getHeight(); i++) {
                    unchangeableBoard.addAll(helper.moveAndMergeEqual(board.getValues(board.getColumn(i))));
                }
                resultBoard = (ArrayList<Integer>) rotate90(unchangeableBoard);
                board.fillBoard(resultBoard);
                break;
            case DOWN:
                for (int i = 0; i < board.getHeight(); i++) {
                    reverse(keysList = board.getColumn(i));
                    exchangingRow = helper.moveAndMergeEqual(board.getValues(keysList));
                    reverse(exchangingRow);
                    unchangeableBoard.addAll(exchangingRow);
                }
                resultBoard = (ArrayList<Integer>) rotate90(unchangeableBoard);

                board.fillBoard(resultBoard);
                break;
        }
        addItem();
        return true;
    }

    public void addItem() {
        Random random = new Random();
            if(!board.availableSpace().isEmpty()){
                int num = random.nextInt(10);
                Key addictedKey = board.availableSpace().get(random.nextInt(board.availableSpace().size()));
                if(num ==10){
                    board.addItem(addictedKey,4);
                }
                else {
                    board.addItem(addictedKey,2);
                }
            }
        }

    @Override
    public Board<Key, Integer> getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }


    private List<Integer> rotate90(List<Integer> list) {
        var newList = new ArrayList<Integer>();
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                newList.add(list.get(j * 4 + i));
            }
        }
        return newList;
    }
}
