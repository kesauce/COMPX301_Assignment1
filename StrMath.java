import java.util.Arrays;
import java.util.List;

class StrMath {
    // Store the digits in an array
    private final List<String> DIGITS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    // Intialise an addition table where the two inputs corresponds to the x and y axis of the table and the answer corresponds to the value at those coordinates.
    // The additon table will returns a 2 digit array of the answer. The first digit is the carry but if there is one.
    private final String[][][] ADDITION_TABLE = {
            //     0              1             2             3             4             5             6             7             8             9
            { { "0", "0" }, { "0", "1" }, { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" } }, // 0
            { { "0", "1" }, { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" } }, // 1
            { { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" } }, // 2
            { { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" } }, // 3
            { { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" } }, // 4
            { { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" } }, // 5
            { { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" }, { "1", "5" } }, // 6
            { { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" }, { "1", "5" }, { "1", "6" } }, // 7
            { { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" }, { "1", "5" }, { "1", "6" }, { "1", "7" } }, // 8
            { { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" }, { "1", "5" }, { "1", "6" }, { "1", "7" }, { "1", "8" } }, // 9
    };

    /**
     * Adds a 1-digit number with another 1-digit number
     * @param firstInput First digit
     * @param secondInput Second digit
     * @return An array of the answer split into 2 digits.
     */
    public String StrAddDigit(String firstInput, String secondInput){
        // Strip the inputs
        String[] firstInputArray = firstInput.split("");
        String[] secondInputArray = secondInput.split("");

        // Ensure the inputs are only 1 digit
        if (firstInputArray.length == 1 && secondInputArray.length == 1){
            // Grab the answer by using the addition table and the inputs as coordinates
            String[] answer = ADDITION_TABLE[DIGITS.indexOf(firstInputArray[0])][DIGITS.indexOf(secondInputArray[0])];

            // Format the answer into a string
            return String.join("", answer);
        }
    
        // Inputs are not single digits.
        else{
            return null;
        }
    }

    public String StrAdd(String input1, String input2) {
        return "";
    }

    public String StrMult(String input1, String input2) {
        return "";
    }

    public String StrFacr(String input) {
        return "";
    }
}