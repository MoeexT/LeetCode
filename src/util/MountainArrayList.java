package util;

import java.util.ArrayList;
import java.util.List;

public class MountainArrayList implements MountainArray {

    private List<Integer> list;

    public MountainArrayList() {
        this.list = new ArrayList<>();
    }

    public void add(int x) {
        list.add(x);
    }

    @Override
    public int get(int index) {
        if (index < this.length())
            return list.get(index);
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int length() {
        return list.size();
    }
}
