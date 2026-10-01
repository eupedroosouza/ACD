import java.util.List;

public class ShellSort extends SwapSort {

    @Override
    public void sort(List<Number> list) {
        final int n = list.size();
        int h = 1;
        do {
            h = (h * 3) + 1;
        } while (h < n);
        do {
            h = h / 3;
            for (int i = h; i < n; i++) {
                iterations++;
                Number x = list.get(i);
                int j = i;
                Number b;
                while ((b = list.get(j - h)).doubleValue() > x.doubleValue()) {
                    iterations++;
                    list.set(j, b);
                    swaps++;
                    j = j - h;
                    if (j < h) {
                        break;
                    }
                }
                list.set(j, x);
                swaps++;
            }
        } while (h != 1);
    }
}
