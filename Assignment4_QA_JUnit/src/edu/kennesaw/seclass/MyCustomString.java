package edu.kennesaw.seclass;

public class MyCustomString implements MyCustomStringInterface {
    private String string;
    public static void main(String[] args) {
        MyCustomString myCustomString = new MyCustomString();
        myCustomString.setString("String");

        System.out.println(myCustomString.getEveryNthCharacterFromBeginningOrEnd(3, false));

    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String input) {
        this.string = input;
    }

    @Override
    public int countNumbers() {
        if (string == null) {
            throw new NullPointerException("Current string is null");
        }
        if (string.isEmpty()) {
            return 0;
        }
        int count = 0;
        boolean isNumber = false;
        //Loop through string, see if any chars are nums
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            //If they are, use isDigit() to find out which one
            if (Character.isDigit(c)) {
                if (!isNumber) {
                    isNumber = true;
                    count++;
                }
            } else {
                isNumber = false;
            }
        }
        //Return num of numbers
        return count;
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero");
        }
        if (string == null && n > 0) {
            throw new NullPointerException("Current string is null");
        }
        if (string.isEmpty() || string.length() < n) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        if (!startFromEnd) {
            //Iterate through string.length() from beginning to end, return result
            for (int i = n - 1; i < string.length(); i += n) {
                result.append(string.charAt(i));
            }
        }
        else {
            //Iterate through string.length() from end to beginning, return result
            for (int i = string.length() - n; i >= 0; i -= n) {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if (startPosition > endPosition) {
            throw new IllegalArgumentException("startPosition must be less than or equal to endPosition");
        }
        if (startPosition <= 0 || endPosition > string.length()) {
            throw new MyIndexOutOfBoundsException("startPosition or endPosition is out of bounds");
        }
        if (string == null) {
            throw new NullPointerException("Current string is null");
        }
        StringBuilder result = new StringBuilder(string);
        for (int i = startPosition - 1; i < endPosition; i++) {
            char c = result.charAt(i);
            //Use isDigit() to compare the char to a number
            //If it equals a num, replace the char with the string in that method
            if (Character.isDigit(c)) {
                String digitName = getDigitName(c);
                result.replace(i, i + 1, digitName);
                i += digitName.length() - 1;
                endPosition += digitName.length() - 1;
            }
        }
        string = result.toString();
    }

    //Helper method to get English names of digits
    private String getDigitName(char c) {
        switch (c) {
            case '0':
                return "Zero";
            case '1':
                return "One";
            case '2':
                return "Two";
            case '3':
                return "Three";
            case '4':
                return "Four";
            case '5':
                return "Five";
            case '6':
                return "Six";
            case '7':
                return "Seven";
            case '8':
                return "Eight";
            case '9':
                return "Nine";
            default:
                return "";
        }
    }
}