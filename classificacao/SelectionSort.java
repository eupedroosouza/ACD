import java.util.List;

public class SelectionSort extends SwapSort {
    @Override
    public void sort(List<Number> list) {
        final int n = list.size();
        for (int i = 0; i < n; i++) {
            int min = i;
            iterations++;
            for (int j = i + 1; j < n; j++) {
                iterations++;
                Number a = list.get(j);
                Number b = list.get(min);
                if (a.doubleValue() < b.doubleValue()) {
                    min = j;
                }
            }
            Number a = list.get(i);
            Number b = list.get(min);
            list.set(min, a);
            list.set(i, b);
            swaps++;
        }
    }
}
