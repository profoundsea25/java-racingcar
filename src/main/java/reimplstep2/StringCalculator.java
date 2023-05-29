package reimplstep2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int ZERO = 0;
    private static final String CUSTOM_DELIMITER_MATCHER = "//(.)\n(.*)";
    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return ZERO;
        }
        return sum(toPositives(split(text)));
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_MATCHER).matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(DELIMITER);
    }

    private static int[] toPositives(String[] split) {
        int[] numbers = new int[split.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toPositive(split[i]);
        }
        return numbers;
    }

    private static int toPositive(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
