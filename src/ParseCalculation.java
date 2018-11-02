import java.lang.Double;

public class ParseCalculation {

    private String input;
    private Double answer;

    public ParseCalculation (String pInput) {
        input = pInput;

    }

    /*
     * Runs the main part of the program to take the input, check for basic errors of input
     * and facilitate the calculation.
     */
    public boolean run () {
        String[] calculation = inputToArray(input);

        if (checkInputSyntax(calculation)) {
            answer = parseString(calculation); // change this value after completing class
            return true;
        } else {
            return false;
        }

    }

    /*
     * takes the input given by user and plits it up into an array using white space
     * as the division point.
     */
    private String[] inputToArray (String pInput) {
        return pInput.split(" ");
    }

    /*
     *
     * parseString
     * Goes through an array of Strings. and performs calculations
     *
     */
    private double parseString (String[] pInput) {
        double total = parseStringToInt(pInput[0]);
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
    private double parseStringToInt(String pIn) {
        Double in = Double.parseDouble(pIn);
        double unwrappedIn = in;
        return unwrappedIn;
    }

    /*
     * Takes the input in array format and checks if two operands are placed next to eachother.
     * If two operands are placed next to eachother, it will return false causing the JTextField
     * in the main window to change the text "Error."
     */
    private boolean checkInputSyntax (String[] pIn) {
        boolean isTrue = true;
        for (int i = 0; i < pIn.length-1; i++) {
            if ((pIn[i].equals("+") || pIn[i].equals("-") || pIn[i].equals("*") || pIn[i].equals("/")) && (pIn[i].equals("+") || pIn[i].equals("-") || pIn[i].equals("*"))) {
                isTrue = true;
            } else {
                isTrue = false;
            }

        }
        return isTrue;
    }

    /*
     * returns the answer integer variable
     */
    public double getAnswer() {
        return answer;
    }

}
