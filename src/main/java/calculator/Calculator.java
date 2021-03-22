package calculator;

public class Calculator {

    public int add(String numbers) {
        String[] arrayNumbers;
        int addingNumbers = 0;

        if (numbers.length() == 0) {
            return 0;
        }

        arrayNumbers = numbers.split("[\n,]");

        for (String arrayNumber : arrayNumbers) {
            addingNumbers += Integer.parseInt(arrayNumber);
        }

        return addingNumbers;

    }

}
