package cup.SingleWeek.cup279.q3;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author 1iin
 */
class Bitset {
    int size;
    BitSet bitSet = new BitSet();
    boolean change = false;
    String str = "";

    public Bitset(int size) {
        this.size = size;
    }

    public void fix(int idx) {
        change = true;
        bitSet.set(idx);
    }

    public void unfix(int idx) {
        change = true;
        bitSet.clear(idx);
    }

    public void flip() {
        change = true;
        bitSet.flip(0, size);
    }

    public boolean all() {
        return bitSet.cardinality() == size;
    }

    public boolean one() {
        return !bitSet.isEmpty();
    }

    public int count() {
        return bitSet.cardinality();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (bitSet.get(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        str = sb.toString();
        change = false;
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */