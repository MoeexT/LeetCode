package interview;


import java.io.*;
import java.util.*;

public class MinRecord {
    static class Record implements Serializable {
        int id;
        byte gender;
        short depart;
        int age;

        Record(int id, byte gender, short depart, int age) {
            this.id = id;
            this.gender = gender;
            this.depart = depart;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    public List<Record> foo(File file) {
        Record[] records = load(file);
        List<Record> ans = new LinkedList<>();
        if (records == null) return ans;
        int SIZE = 128;
        /*FrozenHeap<Record> heap = new FrozenHeap<>(128, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o2.id - o1.id;
            }
        });*/
        PriorityQueue<Record> heap = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o2.id - o1.id;
            }
        });

        for (Record record : records) {
            heap.offer(record);
            if (heap.size() > SIZE) {
                heap.poll();
            }
        }
        while (heap.size() > 0) {
            ans.add(0, heap.poll());
        }

        return ans;
    }

    private Record[] load(File file) {
        Record[] records = null;
        try {
            records = (Record[]) new ObjectInputStream(new FileInputStream(file)).readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public void serializeData() {
        Record[] records = new Record[500];
        for (int i = 0; i < 500; ) {
            records[i] = new Record(i++, (byte) 0, (short) 0, i);
        }
        try {
            FileOutputStream stream = new FileOutputStream("records.ser");
            ObjectOutputStream out = new ObjectOutputStream(stream);
            out.writeObject(records);
            out.close();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MinRecord records = new MinRecord();
        System.out.println(records.foo(new File("records.ser")));
//        records.generateTestFile();
    }
}
