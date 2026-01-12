/**
 * На вход подается строка с цифрами, разделенными либо запятыми, либо тире.
 * Нужно вывести полную последовательность, заменив тире на пропущенные цифры
 */
public class CommasAndDashes {

    private static String decode(String inputString) {
        StringBuilder result = new StringBuilder();

        String[] splittedByCommaStrings = inputString.split(",");
        for (String splittedByComma : splittedByCommaStrings) {
            String[] spliitedByDashesStrings = splittedByComma.split("-");

            int startNumber = Integer.decode(spliitedByDashesStrings[0]);
            int endNumber = spliitedByDashesStrings.length == 2 ? Integer.decode(spliitedByDashesStrings[1]) : startNumber;

            int currentNumber = startNumber;
            do {
                result.append(currentNumber);
                result.append(",");
            } while (++currentNumber <= endNumber);

        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("1"));
        System.out.println(decode("1,2"));
        System.out.println(decode("4-8"));
        System.out.println(decode("1,5-6"));
        System.out.println(decode("10,15-16,18,19,21-24"));
    }

}
