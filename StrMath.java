import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

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

    private final String[][][] MULTIPLICATION_TABLE = {
           //     0              1             2             3             4             5             6             7             8             9
            { { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" } }, // 0
            { { "0", "0" }, { "0", "1" }, { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" } }, // 1
            { { "0", "0" }, { "0", "2" }, { "0", "4" }, { "0", "6" }, { "0", "8" }, { "1", "0" }, { "1", "2" }, { "1", "4" }, { "1", "6" }, { "1", "8" } }, // 2
            { { "0", "0" }, { "0", "3" }, { "0", "6" }, { "0", "9" }, { "1", "2" }, { "1", "5" }, { "1", "8" }, { "2", "1" }, { "2", "4" }, { "2", "7" } }, // 3
            { { "0", "0" }, { "0", "4" }, { "0", "8" }, { "1", "2" }, { "1", "6" }, { "2", "0" }, { "2", "4" }, { "2", "8" }, { "3", "2" }, { "3", "6" } }, // 4
            { { "0", "0" }, { "0", "5" }, { "1", "0" }, { "1", "5" }, { "2", "0" }, { "2", "5" }, { "3", "0" }, { "3", "5" }, { "4", "0" }, { "4", "5" } }, // 5
            { { "0", "0" }, { "0", "6" }, { "1", "2" }, { "1", "8" }, { "2", "4" }, { "3", "0" }, { "3", "6" }, { "4", "2" }, { "4", "8" }, { "5", "4" } }, // 6
            { { "0", "0" }, { "0", "7" }, { "1", "4" }, { "2", "1" }, { "2", "8" }, { "3", "5" }, { "4", "2" }, { "4", "9" }, { "5", "6" }, { "6", "3" } }, // 7
            { { "0", "0" }, { "0", "8" }, { "1", "6" }, { "2", "4" }, { "3", "2" }, { "4", "0" }, { "4", "8" }, { "5", "6" }, { "6", "4" }, { "7", "2" } }, // 8
            { { "0", "0" }, { "0", "9" }, { "1", "8" }, { "2", "7" }, { "3", "6" }, { "4", "5" }, { "5", "4" }, { "6", "3" }, { "7", "2" }, { "8", "1" } }, // 9
    };

    /**
     * Adds a 1-digit number with another 1-digit number
     * @param firstInput First digit
     * @param secondInput Second digit
     * @return An string of the answer
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

    /**
     * Multiplies two single digit numbers
     * @param firstInput First digit
     * @param secondInput Second digit
     * @return A string of the answer
     */
    public String StrMultDigit(String firstInput, String secondInput){
        // Strip the inputs
        String[] firstInputArray = firstInput.split("");
        String[] secondInputArray = secondInput.split("");

        // Ensure the inputs are only 1 digit
        if (firstInputArray.length == 1 && secondInputArray.length == 1){
            // Grab the answer by using the addition table and the inputs as coordinates
            String[] answer = MULTIPLICATION_TABLE[DIGITS.indexOf(firstInputArray[0])][DIGITS.indexOf(secondInputArray[0])];

            // Format the answer into a string
            return String.join("", answer);
        }
    
        // Inputs are not single digits.
        else{
            return null;
        }
    }

    /**
     * Adds any positive number
     * @param firstInput First number
     * @param secondInput Second number
     * @return A string of the answer
     */
    public String StrAdd(String firstInput, String secondInput) {
        // Check which string is shorter and fill it with zero
        String[] firstInputArray = firstInput.split("");
        String[] secondInputArray = secondInput.split("");

        ArrayList<String> formattedFirstInput = new ArrayList<>(Arrays.asList(firstInputArray));
        ArrayList<String> formattedSecondInput = new ArrayList<>(Arrays.asList(secondInputArray));

        // If they're not the same length then pad with zeros
        while(formattedFirstInput.size() != formattedSecondInput.size()){
            if(formattedFirstInput.size() > formattedSecondInput.size()){
                formattedSecondInput.add(0, "0");
            }
            else{
                formattedFirstInput.add(0, "0");
            }
        }

        // Create a list of the carry bits and answer with a default value of 0 
        ArrayList<String> carryBitList = new ArrayList<String>(Collections.nCopies(formattedFirstInput.size(), "0"));
        ArrayList<String> answer = new ArrayList<String>(Collections.nCopies(formattedFirstInput.size(), "0"));

        // Looping for calculation - start on the right side
        for (int i = formattedFirstInput.size() - 1; i >= 0; i--){
            // Add the two digits
            String[] digitAnswer = StrAddDigit(formattedFirstInput.get(i), formattedSecondInput.get(i)).split("");
            //System.out.println(Arrays.toString(digitAnswer));
            // Add the left character to the left column's carry bit if it's one
            if (digitAnswer[0].equals("1")) {
                // If not at zero then insert it at the start
                if (i != 0){
                    carryBitList.set(i-1, digitAnswer[0]);
                }
                else{
                    carryBitList.add(0, digitAnswer[0]);
                }
            }

            // Add the right character to this column's carry bit and store it as a final answer
            String[] carryAnswer = StrAddDigit(digitAnswer[1], carryBitList.get(i)).split("");

            // Add the left character to the left column's carry bit if it's one
            if (carryAnswer[0].equals("1")) {
                // If at zero then insert it at the start
                if (i != 0){
                    carryBitList.set(i-1, carryAnswer[0]);
                }
                else{
                    carryBitList.add(0, carryAnswer[0]);
                }
            }

            answer.set(i, carryAnswer[1]);
        }

        // Check for any left carry bits
        if (carryBitList.size() > formattedFirstInput.size()){
            answer.add(0, carryBitList.get(0));
        }
        return String.join("", answer);
    }

    public String StrMult(String input1, String input2) {
        return "";
    }

    public String StrFacr(String input) {
        return "";
    }
}