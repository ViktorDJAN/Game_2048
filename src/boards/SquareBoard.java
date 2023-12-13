package boards;
import key.Key;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareBoard<V> extends Board<Key,V>  {

    public SquareBoard(int size) {
        super(size, size);
    }

    /**
     * Filling a board with elements of a input list.
     * If it is necessary to set an empty element then set null.
     */
    @Override
    public void fillBoard(List<V> list) {
        try {
            if (list.size() > 16) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            throw new ExceptionInInitializerError();
        }
        Iterator<V> bufferOfValue = list.iterator();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (bufferOfValue.hasNext()) {
                    addItem(new Key(i, j), bufferOfValue.next());
                }
            }
        }
    }

    /**
     * Returning keys equaled null.
     */
    @Override
    public List<Key> availableSpace() {
        var listOfEmptyCells = new ArrayList<Key>();
        if( board.isEmpty()){
            return listOfEmptyCells;
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                var a = getValue(getKey(i, j));
                if (a == null) {
                    listOfEmptyCells.add(getKey(i, j));
                }
            }
        }
        return listOfEmptyCells;
    }

    /**
     * Add an element {@param value} by a key {@param key}.
     */
    @Override
    public void addItem(Key key, V value) {
        board.put(key, value);
    }

    /**
     * Seeking an existing key by coordinates  {@param i} {@param j}.
     */
    @Override
    public Key getKey(int i, int j) {
        if (board.containsKey(new Key(i, j))) {
            return new Key(i, j);
        } else {
            return null;
        }
    }

    /**
     * Get a value by {@param key}.
     */
    @Override
    public V getValue(Key key) {
        return board.get(key);
    }

    /** Get a column of keys which can be used for values choosing after */
    @Override
    public List<Key> getColumn(int i) {
        var resultList = new ArrayList<Key>();
        for (int j = 0; j < height; j++) {
            resultList.add(getKey(j, i));
        }
        return resultList;
    }

    /**
     * Get a row of keys which can be used for values choosing after
     */
    @Override
    public List<Key> getRow(int j) {
        var resultList = new ArrayList<Key>();
        for (int i = 0; i < height; i++) {
            resultList.add(getKey(j, i));
        }
        return resultList;
    }

    /**
     * Checking for availability of the value in the board*/

    @Override
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }

    /**
     * Getting a row of values by the key row*/
    @Override
    public List<V> getValues(List<Key> keys) {
        var resultList = new ArrayList<V>();
        for (Key key : keys) {
            resultList.add(board.get(key));
        }
        return resultList;
    }




}
