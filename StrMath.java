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