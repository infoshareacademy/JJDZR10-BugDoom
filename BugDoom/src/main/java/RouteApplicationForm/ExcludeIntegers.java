package RouteApplicationForm;

public class ExcludeIntegers {

    public static boolean containsIntegers(String s) {
        boolean containsIntegers = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                containsIntegers = true;
                break;
            }
        }
        return containsIntegers;
    }
}
