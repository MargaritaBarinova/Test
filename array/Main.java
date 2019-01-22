package array;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String[][] array = {{"0", "0", "1", "0"},
                            {"1", "0", "1", "0"},
                            {"1", "0", "2", "0"},
                            {"3", "0", "1", "0"}};
        int sumArrayElements = 0;
        try {
            sumArrayElements = sumArrayElements(array);
            System.out.println("Сумма элементов массива " + sumArrayElements);
        }
        catch (MyArraySizeException e) {
            System.out.println(e.text);
        }
        catch (MyArrayDataException e) {
            System.out.println(e.text);
        }
    }

    public static int sumArrayElements(String[][] digits) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (digits.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (String[] row : digits) {
                if (row.length != 4) {
                    throw new MyArraySizeException();
                }
                for (String element : row) {
                    try {
                        int digit = Integer.parseInt(element);
                        sum += digit;
                    } catch (Exception e) {
                        throw new MyArrayDataException();
                    }
                }
            }
        }
        return sum;
    }
}
