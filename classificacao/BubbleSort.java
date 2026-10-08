import java.util.List;

public class BubbleSort extends SwapSort {

    @Override
    public void sort(List<Number> list) {
        boolean change = true;
        final int lastIndex = list.size() - 1; // index start with 0 (then last index is size - 1)
        for (int i = 0; i < lastIndex && change; i++) {
            iterations++;
            change = false;
            for (int j = lastIndex; j > i; j--) {
                iterations++;
                int neighborIdx = j - 1;
                Number a = list.get(j);
                Number b = list.get(neighborIdx);
                if (a.doubleValue() < b.doubleValue()) {
                    change = true;
                    list.set(j, b);
                    list.set(neighborIdx, a);
                    swaps++;
                }
            }
        }

    }
}
