package key;

import java.util.Objects;

public class Key {
    private int i;
    private int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Key(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public boolean equals(Object o){
        return (boolean) o;
    }
    public int hashCode(){
        return Objects.hash(i,j);
    }
}