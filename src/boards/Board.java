package boards;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  abstract class Board {
    int width;
    int height;
    Map<key.Key,Integer> board = new HashMap<>();

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Map<key.Key, Integer> getBoard() {
        return board;
    }

    public void setBoard(Map<key.Key, Integer> board) {
        this.board = board;
    }

    public abstract void fillBoard(List<Integer> list);

    public abstract List<key.Key> availableSpace();

    public abstract void addItem(key.Key key, Integer value);


    public abstract Key getKey(int i , int j);

    public abstract List<key.Key> getColumn(int j);

    public abstract List<key.Key> getRow(int i);



    public abstract boolean hasValue(Integer score);

    public abstract boolean hasValue(key.Key key);

    public abstract List<Integer> getValues(List<key.Key> keys);

    public abstract List<Integer> getColumnValues(int j);

    public abstract List<Integer> getRowValues(int i);

}
