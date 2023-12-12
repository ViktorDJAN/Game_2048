package boards;



import key.Key;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SquareBoard<V> extends Board<Key,V> {
    int size;

    public SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    /**
     * Filling a board with elements of a input list
     * If it is necessary to set an empty element then set null
     */

    @Override
    public void fillBoard(List<V> list) {
        Iterator<V> iterator = list.listIterator();
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (iterator.hasNext()) {
                    board.put(new Key(i, j), list.get(index++));
                } else {
                    board.put(new Key(i, j), null); // instead might be break
                }
            }
        }

    }

    /**
     * Returning keys equaled null
     */
    @Override
    public List<Key> availableSpace() {
        Map<Key, V> sourceBoard = board;
        List<Key> listNulls = new ArrayList<>();
        for (Map.Entry entry : sourceBoard.entrySet()) {
            if (entry.getKey() == null) {
                listNulls.add((Key) entry.getKey());
            }
        }
        return listNulls;
    }

    public List<Key> getKeys() {
        Map<Key, V> sourceBoard = board;
        List<key.Key> listNulls = new ArrayList<>();
        for (Map.Entry entry : sourceBoard.entrySet()) {
                listNulls.add((key.Key) entry.getKey());

        }
        return listNulls;
    }
    /**
     * Add an element {@param value} by a key {@param key}.
     */
    @Override
    public void addItem(Key key, V value) {
        if (!board.containsKey(key)) {
            board.put(key, value);
        }
    }


    /**
     * Seeking an existing key by coordinates  {@param i} {@param j}.
     */

    @Override
    public Key getKey(int i, int j) {
        for (Map.Entry<Key,V> entry : board.entrySet()) {
            if (entry.getKey().equals(new Key(i,j))) {
                return (Key) entry.getKey();
            }
        }
        return null;
    }

    @Override
    public V getValue(Key key) {
        return board.get(key);
    }

    /** Get a column of keys which can be used for values choosing after */
    @Override
    public  List<Key> getColumn(int j){
        List<key.Key>columnsList = new ArrayList<>();
        for(Map.Entry<Key,V> entry: board.entrySet()){
            if(entry.getKey().getJ()==j){
                columnsList.add(entry.getKey());
            }
        }
        return columnsList;
    }

    /** Get a row of keys which can be used for values choosing after
     */
    @Override
    public List<Key> getRow(int i) {
        List<key.Key>rowsList = new ArrayList<>();
        for(Map.Entry<Key,V> entry: board.entrySet()){
            if(entry.getKey().getI()==i){
                rowsList.add(entry.getKey());
            }
        }
        return rowsList;
    }




    /**
     * Checking for availability of the value in the board*/
    @Override
    public boolean hasValue(V score) {
        if (board.containsValue(score)) {
            return true;
        }
        return false;
    }

   /**
    * Getting a row of values by the key row*/

    @Override
    public List<V> getValues(List<Key> keys) {
        List<V>valuesRow = new ArrayList<>();
        for(Key key : keys){
            valuesRow.add(board.get(key));
        }
        return valuesRow;
    }
     public List<V> getRowValues(int i){
         return getValues(getRow(i));
     }
    public List<V> getColumnValues(int j){
        return getValues(getRow(j));
    }


}
