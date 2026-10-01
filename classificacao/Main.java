import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static final int SAMPLE_SIZE = 50;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        List<Number> list = new ArrayList<>();
        // Sel
        // 1 = random
        // 2 = crescent
        // 3 = decrescent
        System.out.println("Select mode: ");
        System.out.println("[1] - Random");
        System.out.println("[2] - Crescent");
        System.out.println("[3] - Decrescent");
        int sel = scanner.nextInt();
        if (sel == 1) {
            for (int i = 0; i < SAMPLE_SIZE; i++) {
                list.add(ThreadLocalRandom.current().nextInt(0, 500));
            }
        } else  if (sel == 2) {
            for (int i = 1; i <= SAMPLE_SIZE; i++) {
                list.add(i);
            }

        } else  if (sel == 3) {
            for (int i = SAMPLE_SIZE; i > 0; i--) {
                list.add(i);
            }
        } else {
            System.out.println("Invalid mode select: " + sel);
            return;
        }


        System.out.println("Original: " + Util.listToString(list));

        System.out.println();

        List<Number> copy = new ArrayList<>(list);

        // Bubble
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(copy);
        System.out.println("BubbleSort:");
        System.out.println(" Ordered: " + Util.listToString(copy));
        System.out.println(" Swaps: " + bubbleSort.getSwaps());
        System.out.println(" Iterations: " + bubbleSort.getIterations());
        System.out.println(" Check: " + (Util.checkOrdered(list, copy) ? "OK!" : "Invalid order"));

        System.out.println();

        // Selection
        copy = new ArrayList<>(list);
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(copy);
        System.out.println("SelectionSort:");
        System.out.println(" Ordered: " + Util.listToString(copy));
        System.out.println(" Swaps: " + selectionSort.getSwaps());
        System.out.println(" Iterations: " + selectionSort.getIterations());
        System.out.println(" Check: " + (Util.checkOrdered(list, copy) ? "OK!" : "Invalid order"));

        System.out.println();

        // Shell
        copy = new ArrayList<>(list);
        ShellSort shellSort = new ShellSort();
        shellSort.sort(copy);
        System.out.println("ShellSort:");
        System.out.println(" Ordered: " + Util.listToString(copy));
        System.out.println(" Swaps: " + selectionSort.getSwaps());
        System.out.println(" Iterations: " + shellSort.getIterations());
        System.out.println(" Check: " + (Util.checkOrdered(list, copy) ? "OK!" : "Invalid order"));

    }

}
