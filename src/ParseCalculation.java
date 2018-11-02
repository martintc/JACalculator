import java.util.ArrayList;
import java.lang.Integer;

public class ParseCalculation {

    private String input;

    public ParseCalculation (String pInput) {
        input = pInput;

    }

    public int run () {
        String[] calculation = inputToArray(input);
        return parseString(calculation); // change this value after completing class
    }

    private String[] inputToArray (String pInput) {
        return pInput.split(" ");
    }

    /*
     *
     * parseString
     * Goes through an array of Strings. and performs calculations
     *
     */
    private int parseString (String[] pInput) {
        int total = parseStringToInt(pInput[0]);
        for (int i = 1; i < pInput.length; i++) {
            if (pInput[i].equals("+")) {
                total = total + parseStringToInt(pInput[i+1]);
            } else if (pInput[i].equals("-")) {
                total = total - parseStringToInt(pInput[i+1]);
            } else if (pInput[i].equals("*")) {
                total = total * parseStringToInt(pInput[i+1]);
            } else if (pInput[i].equals("/")) {
                total = total / parseStringToInt(pInput[i+1]);
            } else {
                // do nothing
            }
        }
        return total;
    }

    /*
     *
     * parseStringToInt
     * Takes a string, parses it's value into an object of Integer.
     * Then it unboxes the value into a primitive type of int.
     *
     */
    private int parseStringToInt(String pIn) {
        Integer in = Integer.parseInt(pIn);
        int unwrappedIn = in;
        return unwrappedIn;
    }

}
