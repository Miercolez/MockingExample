package calculator;

public class Calculator {

    public int add(String numbers) {
        String[] arrayNumbers;
        int addingNumbers = 0;
        boolean illegalException = false;
        StringBuilder negativeNumbers = new StringBuilder();

        arrayNumbers = numbers.split("[\n,;/]");

        for (String arrayNumber : arrayNumbers) {
            if (!arrayNumber.isEmpty()) {
                addingNumbers += Integer.parseInt(arrayNumber);

                if (Integer.parseInt(arrayNumber) < 0) {
                    illegalException = true;
                    negativeNumbers.append(" ").append(arrayNumber);
                }
            }
        }

        if (illegalException) {
            throw new IllegalArgumentException("negatives not allowed" + negativeNumbers);
        }

        return addingNumbers;

    }

}
