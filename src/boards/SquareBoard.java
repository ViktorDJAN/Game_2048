package boards;


import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SquareBoard extends Board {
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
    public void fillBoard(List<Integer> list) {
        Iterator<Integer> iterator = list.listIterator();
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (iterator.hasNext()) {
                    board.put(new key.Key(i, j), list.get(index++));
                } else {
                    board.put(new key.Key(i, j), null); // instead might be break
                }
            }
        }

    }

    /**
     * Returning keys equaled null
     */
    @Override
    public List<key.Key> availableSpace() {
        Map<key.Key, Integer> sourceBoard = board;
        List<key.Key> listNulls = new ArrayList<>();
        for (Map.Entry entry : sourceBoard.entrySet()) {
            if (entry.getKey() == null) {
                listNulls.add((key.Key) entry.getKey());
            }
        }
        return listNulls;
    }

    public List<key.Key> getKeys() {
        Map<key.Key, Integer> sourceBoard = board;
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
    public void addItem(key.Key key, Integer value) {
        if (!board.containsKey(key)) {
            board.put(key, value);
        }
    }


    /**
     * Seeking an existing key by coordinates  {@param i} {@param j}.
     */

    @Override
    public Key getKey(int i, int j) {
        for (Map.Entry<key.Key,Integer> entry : board.entrySet()) {
            if (entry.getKey().equals(new key.Key(i,j))) {
                return (Key) entry.getKey();
            }
        }
        return null;
    }
    /** Get a column of keys which can be used for values choosing after */
    @Override
    public  List<key.Key> getColumn(int j){
        List<key.Key>columnsList = new ArrayList<>();
        for(Map.Entry<key.Key,Integer> entry: board.entrySet()){
            if(entry.getKey().getJ()==j){
                columnsList.add(entry.getKey());
            }
        }
        return columnsList;
    }

    /** Get a row of keys which can be used for values choosing after
     */
    @Override
    public List<key.Key> getRow(int i) {
        List<key.Key>rowsList = new ArrayList<>();
        for(Map.Entry<key.Key,Integer> entry: board.entrySet()){
            if(entry.getKey().getI()==i){
                rowsList.add(entry.getKey());
            }
        }
        return rowsList;
    }

    @Override
    public boolean hasValue(Integer score) {
        return false;
    }

    /**
     * Checking for availability of the value in the board*/
    @Override
    public boolean hasValue(key.Key key) {
        if(board.containsKey(key)){
            return true;
        }
        return false;
    }
   /**
    * Getting a row of values by the key row*/

    @Override
    public List<Integer> getValues(List<key.Key> keys) {
        List<Integer>valuesRow = new ArrayList<>();
        for(key.Key key : keys){
            valuesRow.add(board.get(key));
        }
        return valuesRow;
    }
     public List<Integer> getRowValues(int i){
         return getValues(getRow(i));
     }
    public List<Integer> getColumnValues(int j){
        return getValues(getRow(j));
    }


}
