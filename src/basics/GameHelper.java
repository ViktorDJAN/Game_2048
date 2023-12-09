package basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameHelper{
    public List<Integer>moveAndMergeEqual(List<Integer> list){
        ArrayList<Integer>tempo = new ArrayList<>();
        ArrayList<Integer>result = new ArrayList<>();

        for(int i = 0;i<list.size();i++){
            if(list.get(i)!=null){
                tempo.add(list.get(i));
            }
        }

        for(int i = 0; i<tempo.size()-1;i++){
            if(tempo.get(i)==tempo.get(i+1)){
                tempo.set(i,(tempo.get(i+1)+tempo.get(i)));
                tempo.remove(i+1);
            }
        }

        result.addAll(tempo);

        while(result.size()!=list.size()){
            result.add(null);
        }

        return result;
    }
}
