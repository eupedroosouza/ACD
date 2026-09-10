import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum implements Expression {

    private final List<Expression> values;

    public Sum(List<Expression> values) {
        this.values = values;
    }

    public Sum(Expression... values) {
        this.values = Arrays.asList(values);
    }

    @Override
    public double evaluate() {
        double cumul = 0;
        for (Expression value : values) {
            cumul += value.evaluate();
        }
        return cumul;
    }

    @Override
    public String toString() {
        List<String> mapped = new ArrayList<>();
        for (Expression value : values) {
            mapped.add(value.toString());
        }
        // A partir do Java 8 podemos utilizar algo mais simples de escrever como:
        // List<String> mapped = values.stream().map(e -> String.format("%.2f", e.evaluate())).toList();
        return "Sum(" + String.join(" + ", mapped) +" = " + String.format("%.2f", evaluate()) + ")";
    }
}
