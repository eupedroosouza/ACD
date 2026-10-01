import java.util.List;

public class Util {

    public static String listToString(List<?> list) {
        return "[" + String.join(", ", list.stream().map(Object::toString).toList()) + "]";
    }

    public static boolean checkOrdered(List<Number> a, List<Number> b) {
        boolean check = true;
        for (Number number : a) {
            if (!b.contains(number)) {
                check = false;
                break;
            }
        }
        return check;
    }


}
