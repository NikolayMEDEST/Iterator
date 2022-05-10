import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    List<Integer> list = new ArrayList<>();

    public Randoms(int min, int max) {
        int i = 0;
        while (true) {
            list.add(new Random().nextInt(max - min) + min);
            if (list.get(i) == 100) {
                break;
            }
            i++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            int nextIndex = 0;

            //   boolean isExist = true;
            @Override
            public boolean hasNext() {
                if (list.get(nextIndex) == 100) {
                    System.out.println("Выпало число 100, давайте на этом закончим");
                    return false;
                }
                return true;
            }

            @Override
            public Integer next() {
                int curIndex = nextIndex;
                nextIndex++;
                return list.get(curIndex);
            }
        };
    }
}