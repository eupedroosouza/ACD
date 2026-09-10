import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Division implements Expression {

    private final List<Expression> values;

    public Division(List<Expression> values) {
        this.values = values;
    }

    public Division(Expression... values) {
        this.values = Arrays.asList(values);
    }

    @Override
    public double evaluate() {
        double cumul = values.getFirst().evaluate();
        for (int i = 1; i < values.size(); i++) {
            cumul /= values.get(i).evaluate();
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
        return "Division(" + String.join(" / ", mapped) + " = " + String.format("%.2f", evaluate()) + ")";
    }
}
