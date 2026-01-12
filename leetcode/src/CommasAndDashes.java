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

    private static String decode2(String inputString) {

        StringBuilder result = new StringBuilder();
        int currentIndex = 0;
        StringBuilder currentNumber = new StringBuilder();

        while (currentIndex < inputString.length()) {

            if (inputString.charAt(currentIndex) == ',') {
                result.append(currentNumber).append(",");
                currentNumber = new StringBuilder();
                currentIndex++;

            } else if (inputString.charAt(currentIndex) == '-') {
                int startNumber = Integer.decode(currentNumber.toString());
                StringBuilder endNumberString = new StringBuilder();
                while (++currentIndex < inputString.length() && inputString.charAt(currentIndex) != ',') {
                    endNumberString.append(inputString.charAt(currentIndex));
                }
                int currentNumberInDashPart = startNumber;
                int endNumber = Integer.decode(endNumberString.toString());
                do {
                    result.append(currentNumberInDashPart);
                    result.append(",");
                } while (++currentNumberInDashPart <= endNumber);
                currentNumber = new StringBuilder();
                currentIndex++;

            } else {
                currentNumber.append(inputString.charAt(currentIndex));
                currentIndex++;
            }

        }

        if (!currentNumber.isEmpty()) {
            result.append(currentNumber).append(",");
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static void main(String[] args) {
//        System.out.println(decode("1"));
//        System.out.println(decode("1,2"));
//        System.out.println(decode("4-8"));
//        System.out.println(decode("1,5-6"));
//        System.out.println(decode("10,15-16,18,19,21-24"));
//
//        System.out.println("----");

        System.out.println(decode2("18-20,101-105"));
        System.out.println(decode2("18-20,101-105,107"));
        System.out.println(decode2("1"));
        System.out.println(decode2("123"));
        System.out.println(decode2("1,2"));
        System.out.println(decode2("4-8"));
        System.out.println(decode2("1,5-6"));
        System.out.println(decode2("10,15-16,18,19,21-24"));

    }

}
