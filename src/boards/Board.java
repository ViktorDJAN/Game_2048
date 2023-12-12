package boards;

import key.Key;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  abstract class Board<K,V> {
    int width;
    int height;
    Map<K,V> board = new HashMap<>();

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

    public Map<K, V> getBoard() {
        return board;
    }

    public void setBoard(Map<K,V> board) {
        this.board = board;
    }

    public abstract void fillBoard(List<V> list);

    public abstract List<K> availableSpace();

    public abstract void addItem(K key, V value);


    public abstract Key getKey(int i , int j);
    public abstract V getValue(Key key);


    public abstract List<K> getColumn(int j);

    public abstract List<K> getRow(int i);



    public abstract boolean hasValue(V value);

    public abstract List<V> getValues(List<K> keys);

    public abstract List<V> getColumnValues(int j);

    public abstract List<V> getRowValues(int i);

}
