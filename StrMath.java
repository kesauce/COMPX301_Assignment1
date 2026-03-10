import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class StrMath {
    // Store the digits in an array
    private final List<String> DIGITS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    // Intialise an addition table where the two inputs corresponds to the x and y
    // axis of the table and the answer corresponds to the value at those
    // coordinates.
    // The additon table will returns a 2 digit array of the answer. The first digit
    // is the carry but if there is one.
    private final String[][][] ADDITION_TABLE = {
            // 0 1 2 3 4 5 6 7 8 9
            { { "0", "0" }, { "0", "1" }, { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" },
                    { "0", "7" }, { "0", "8" }, { "0", "9" } }, // 0
            { { "0", "1" }, { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" },
                    { "0", "8" }, { "0", "9" }, { "1", "0" } }, // 1
            { { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" },
                    { "0", "9" }, { "1", "0" }, { "1", "1" } }, // 2
            { { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" },
                    { "1", "0" }, { "1", "1" }, { "1", "2" } }, // 3
            { { "0", "4" }, { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" },
                    { "1", "1" }, { "1", "2" }, { "1", "3" } }, // 4
            { { "0", "5" }, { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" },
                    { "1", "2" }, { "1", "3" }, { "1", "4" } }, // 5
            { { "0", "6" }, { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" },
                    { "1", "3" }, { "1", "4" }, { "1", "5" } }, // 6
            { { "0", "7" }, { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" },
                    { "1", "4" }, { "1", "5" }, { "1", "6" } }, // 7
            { { "0", "8" }, { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" },
                    { "1", "5" }, { "1", "6" }, { "1", "7" } }, // 8
            { { "0", "9" }, { "1", "0" }, { "1", "1" }, { "1", "2" }, { "1", "3" }, { "1", "4" }, { "1", "5" },
                    { "1", "6" }, { "1", "7" }, { "1", "8" } }, // 9
    };

    private final String[][][] MULTIPLICATION_TABLE = {
            // 0 1 2 3 4 5 6 7 8 9
            { { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" },
                    { "0", "0" }, { "0", "0" }, { "0", "0" } }, // 0
            { { "0", "0" }, { "0", "1" }, { "0", "2" }, { "0", "3" }, { "0", "4" }, { "0", "5" }, { "0", "6" },
                    { "0", "7" }, { "0", "8" }, { "0", "9" } }, // 1
            { { "0", "0" }, { "0", "2" }, { "0", "4" }, { "0", "6" }, { "0", "8" }, { "1", "0" }, { "1", "2" },
                    { "1", "4" }, { "1", "6" }, { "1", "8" } }, // 2
            { { "0", "0" }, { "0", "3" }, { "0", "6" }, { "0", "9" }, { "1", "2" }, { "1", "5" }, { "1", "8" },
                    { "2", "1" }, { "2", "4" }, { "2", "7" } }, // 3
            { { "0", "0" }, { "0", "4" }, { "0", "8" }, { "1", "2" }, { "1", "6" }, { "2", "0" }, { "2", "4" },
                    { "2", "8" }, { "3", "2" }, { "3", "6" } }, // 4
            { { "0", "0" }, { "0", "5" }, { "1", "0" }, { "1", "5" }, { "2", "0" }, { "2", "5" }, { "3", "0" },
                    { "3", "5" }, { "4", "0" }, { "4", "5" } }, // 5
            { { "0", "0" }, { "0", "6" }, { "1", "2" }, { "1", "8" }, { "2", "4" }, { "3", "0" }, { "3", "6" },
                    { "4", "2" }, { "4", "8" }, { "5", "4" } }, // 6
            { { "0", "0" }, { "0", "7" }, { "1", "4" }, { "2", "1" }, { "2", "8" }, { "3", "5" }, { "4", "2" },
                    { "4", "9" }, { "5", "6" }, { "6", "3" } }, // 7
            { { "0", "0" }, { "0", "8" }, { "1", "6" }, { "2", "4" }, { "3", "2" }, { "4", "0" }, { "4", "8" },
                    { "5", "6" }, { "6", "4" }, { "7", "2" } }, // 8
            { { "0", "0" }, { "0", "9" }, { "1", "8" }, { "2", "7" }, { "3", "6" }, { "4", "5" }, { "5", "4" },
                    { "6", "3" }, { "7", "2" }, { "8", "1" } }, // 9
    };

    /**
     * Adds a 1-digit number with another 1-digit number
     * 
     * @param firstInput  First digit
     * @param secondInput Second digit
     * @return An string of the answer
     */
    public String StrAddDigit(String firstInput, String secondInput) {
        // Strip the inputs
        String[] firstInputArray = firstInput.split("");
        String[] secondInputArray = secondInput.split("");

        // Ensure the inputs are only 1 digit
        if (firstInputArray.length == 1 && secondInputArray.length == 1) {
            // Grab the answer by using the addition table and the inputs as coordinates
            String[] answer = ADDITION_TABLE[DIGITS.indexOf(firstInputArray[0])][DIGITS.indexOf(secondInputArray[0])];

            // Format the answer into a string
            return String.join("", answer);
        }

        // Inputs are not single digits.
        else {
            return null;
        }
    }

    /**
     * Multiplies two single digit numbers
     * 
     * @param firstInput  First digit
     * @param secondInput Second digit
     * @return A string of the answer
     */
    public String StrMultDigit(String firstInput, String secondInput) {
        // Strip the inputs
        String[] firstInputArray = firstInput.split("");
        String[] secondInputArray = secondInput.split("");

        // Ensure the inputs are only 1 digit
        if (firstInputArray.length == 1 && secondInputArray.length == 1) {
            // Grab the answer by using the addition table and the inputs as coordinates
            String[] answer = MULTIPLICATION_TABLE[DIGITS.indexOf(firstInputArray[0])][DIGITS
                    .indexOf(secondInputArray[0])];

            // Format the answer into a string
            return String.join("", answer);
        }

        // Inputs are not single digits.
        else {
            return null;
        }
    }

    /**
     * Adds any positive number
     * 
     * @param firstInput  First number
     * @param secondInput Second number
     * @return A string of the answer
     */
    public String StrAdd(String firstInput, String secondInput) {
        ArrayList<String> formattedFirstInput = new ArrayList<>(Arrays.asList(firstInput.split("")));
        ArrayList<String> formattedSecondInput = new ArrayList<>(Arrays.asList(secondInput.split("")));

        // If they're not the same length then pad with zeros
        while (formattedFirstInput.size() != formattedSecondInput.size()) {
            if (formattedFirstInput.size() > formattedSecondInput.size()) {
                formattedSecondInput.add(0, "0");
            } else {
                formattedFirstInput.add(0, "0");
            }
        }

        // Create a list of the carry bits and answer with a default value of 0
        ArrayList<String> carryBitList = new ArrayList<String>(Collections.nCopies(formattedFirstInput.size(), "0"));
        ArrayList<String> answer = new ArrayList<String>(Collections.nCopies(formattedFirstInput.size(), "0"));

        // Looping for calculation - start on the right side
        for (int i = formattedFirstInput.size() - 1; i >= 0; i--) {
            // Add the two digits
            String[] digitAnswer = StrAddDigit(formattedFirstInput.get(i), formattedSecondInput.get(i)).split("");
            // Add the left character to the left column's carry bit if it's one
            if (digitAnswer[0].equals("1")) {
                // If not at zero then insert it at the start
                if (i != 0) {
                    carryBitList.set(i - 1, digitAnswer[0]);
                } else {
                    carryBitList.add(0, digitAnswer[0]);
                }
            }

            // Add the right character to this column's carry bit and store it as a final
            // answer
            String[] carryAnswer = StrAddDigit(digitAnswer[1], carryBitList.get(i)).split("");

            // Add the left character to the left column's carry bit if it's one
            if (carryAnswer[0].equals("1")) {
                // If at zero then insert it at the start
                if (i != 0) {
                    carryBitList.set(i - 1, carryAnswer[0]);
                } else {
                    carryBitList.add(0, carryAnswer[0]);
                }
            }

            answer.set(i, carryAnswer[1]);
        }

        // Check for any left carry bits
        if (carryBitList.size() > formattedFirstInput.size()) {
            answer.add(0, carryBitList.get(0));
        }
        return String.join("", answer);
    }

    /**
     * Multiplies two digits together
     * 
     * @param firstInput  First number
     * @param secondInput Second number
     * @return A string of the answer
     */
    public String StrMult(String firstInput, String secondInput) {
        // Format the inputs
        ArrayList<String> formattedFirstInput = new ArrayList<>(Arrays.asList(firstInput.split("")));
        ArrayList<String> formattedSecondInput = new ArrayList<>(Arrays.asList(secondInput.split("")));

        // Intialise answer
        ArrayList<String> answer = new ArrayList<String>();

        // Use a nested loop to multiply every number by every number
        for (int i = formattedFirstInput.size() - 1; i >= 0; i--) {
            // Create an arraylist to store the carry bit and define the size of it to the
            // number that is bigger between the inputs
            ArrayList<String> carryBitList = new ArrayList<String>(Collections
                    .nCopies(formattedFirstInput.size() > formattedSecondInput.size() ? formattedFirstInput.size()
                            : formattedSecondInput.size(), "0"));
            String iterationAnswer = "";

            for (int j = formattedSecondInput.size() - 1; j >= 0; j--) {
                // Multiply the two digits and add the carry to the answer
                String multAnswer = StrMultDigit(formattedFirstInput.get(i), formattedSecondInput.get(j));
                String[] carryAnswer = StrAdd(multAnswer, carryBitList.get(j)).split("");

                // Append the second digit to the iteration answer
                iterationAnswer = carryAnswer[1] + iterationAnswer;

                // Append the first digit to the left index of the carry bit
                if (j == 0 && !carryAnswer[0].equals("0")) {
                    carryBitList.add(0, carryAnswer[0]);
                } else if (!carryAnswer[0].equals("0")) {
                    carryBitList.set(j - 1, carryAnswer[0]);
                }
            }

            // Check for any left carry bits
            if (carryBitList
                    .size() > (formattedFirstInput.size() > formattedSecondInput.size() ? formattedFirstInput.size()
                            : formattedSecondInput.size())) {
                iterationAnswer = carryBitList.get(0) + iterationAnswer;
            }

            // Add the iteration answer to the answer
            answer.add(iterationAnswer);
        }

        // Add 0s accordingly to each iteration answer
        for (int i = 0; i < answer.size(); i++) {
            String newAnswer = answer.get(i) + String.valueOf("0").repeat(i);
            answer.set(i, newAnswer);
        }

        // Add all the answers together
        String finalAnswer = "0";
        for (String iterationAnswer : answer) {
            finalAnswer = StrAdd(finalAnswer, iterationAnswer);
        }

        return finalAnswer;
    }
    /**
     * Calculates the factorial of a given number.
     * @param input The value.
     * @return A string of the answer.
     */
    public String StrFact(String input) {
        if (input.equals("0") || input.equals("1")) {
            return "1";
        } else {
            String counter = "1";
            String answer = "1";
            while (!counter.equals(input)) {
                answer = StrMult(StrAdd(counter, "1"), answer);
                counter = StrAdd(counter, "1");
            }
            return answer;
        }
    }
}