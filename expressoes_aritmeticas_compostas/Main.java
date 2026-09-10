public class Main {

    public static void main(String[] args) {

        System.out.println("Expression: (10 + 20) * (50 - 5)");
        Number num10 = new Number(10);
        Number num20 = new Number(20);
        Sum sum = new Sum(num10, num20);

        Number num50 = new Number(50);
        Number num5 = new Number(5);
        Subtraction subtraction = new Subtraction(num50, num5);

        Multiplication multiplication = new Multiplication(sum, subtraction);
        System.out.println(multiplication);
        System.out.println("Final result: " + String.format("%.2f", multiplication.evaluate()));

        System.out.println();

        System.out.println("Expression: (10 + 20 + 30)");
        Sum sum2 = new Sum(new Number(10), new Number(20), new Number(30));
        System.out.println(sum2);
        System.out.println("Final result: " + String.format("%.2f", sum2.evaluate()));

        System.out.println();

        System.out.println("Expression: ((10 + 20) × 5) - ((100 / 4) + 7)");
        Expression part1 = new Multiplication(new Sum(new Number(10), new Number(20)), new Number(5));
        Expression part2 = new Sum(new Division(new Number(100), new Number(4)), new Number(7));
        Subtraction sub2 = new Subtraction(part1, part2);
        System.out.println(sub2);
        System.out.println("Final result: " + String.format("%.2f", sub2.evaluate()));


    }

}