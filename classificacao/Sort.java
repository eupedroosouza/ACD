import java.util.List;

public abstract class Sort {

    protected int iterations;

    public abstract void sort(List<Number> list);

    public int getIterations() {
        return iterations;
    }
}
