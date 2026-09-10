public class Number implements Expression {

    private final double value;

    public Number() {
        this.value = 0;
    }

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return "Number(" + String.format("%.2f", evaluate()) + ")";
    }
}
