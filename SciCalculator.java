import java.util.Scanner;

public class SciCalculator {// Michael Ivanov, lab partner: Kyle Helstrom
    private static double firstOperand;// Git test push
    private static double secondOperand;
    private static double calcResult = 0.0;
    private static double totalNumbers = 0.0;
    private static double lastResult = 0.0;
    private static int numOfCalculations = 0;
    private static Scanner myScanner = new Scanner(System.in);

    private static double inputOne() { //Method for returning first operand
        System.out.print("Enter first operand: ");
        String firstNumber;
        firstNumber = myScanner.next();
        if (firstNumber.equals("RESULT")) { // if the input is "RESULT" it returns the last result
            return lastResult;
        } else {
            firstOperand = Double.parseDouble(firstNumber);
            return firstOperand;
        }

    }

    private static double inputTwo() { //Method to return the second operand
        System.out.print("Enter second operand: ");
        String secondNumber;
        secondNumber = myScanner.next();
        if (secondNumber.equals("RESULT")) { // if the input is "RESULT" it returns the last result
            return lastResult;
        } else {
            secondOperand = Double.parseDouble(secondNumber);
            return secondOperand;
        }
    }

    private static double numRound() {//Method to round the result of the calculation
        calcResult *= 1000.0;
        calcResult = Math.round(calcResult);
        calcResult /= 1000.0;
        return calcResult;
    }

    public static void main(String[] args) {//A scientific calculator which allows selection of operation then input of two numbers

        int menuSelect;
        boolean calcRun = true;
        boolean switchLoop;
        firstOperand = 0.0;
        secondOperand = 0.0;

        while (calcRun) {

            switchLoop = true;
            System.out.println("\nCurrent Result: " + calcResult);
            lastResult = calcResult; //stores the result to be used in future calculations
            totalNumbers += calcResult; //the summation of all results while the program is run
            calcResult = 0.0;
            System.out.println("\nCalculator Menu\n --------------- \n0. Exit Program \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division \n5. Exponentiation \n6. Logarithm \n7. Display Average \n");
            while (switchLoop) {


                System.out.print("Enter Menu Selection: ");
                menuSelect = myScanner.nextInt();
                switch (menuSelect) {
                    case 0: //Exit Program
                        System.out.println("\nThanks for using this calculator. Goodbye! ");
                        switchLoop = false;
                        calcRun = false;
                        break;
                    case 1: //Addition
                        firstOperand = inputOne(); //calls the input method to receive first operand
                        secondOperand = inputTwo();
                        calcResult = (firstOperand + secondOperand);
                        calcResult = numRound(); //calls the numRound method to round the result
                        switchLoop = false;
                        break;
                    case 2: //Subtraction
                        firstOperand = inputOne();
                        secondOperand = inputTwo();
                        calcResult = (firstOperand - secondOperand);
                        calcResult = numRound();
                        switchLoop = false;
                        break;
                    case 3: //Multiplication
                        firstOperand = inputOne();
                        secondOperand = inputTwo();
                        calcResult = (firstOperand * secondOperand);
                        calcResult = numRound();
                        switchLoop = false;
                        break;
                    case 4: //Division
                        firstOperand = inputOne();
                        secondOperand = inputTwo();
                        calcResult = (firstOperand / secondOperand);
                        calcResult = numRound();
                        switchLoop = false;
                        break;
                    case 5: //Exponentiation (first operand is the base and the second is the exponent)
                        firstOperand = inputOne();
                        secondOperand = inputTwo();
                        calcResult = (Math.pow(firstOperand, secondOperand));
                        calcResult = numRound();
                        switchLoop = false;
                        break;
                    case 6: //Logarithm (second operand is the base of the log)
                        firstOperand = inputOne();
                        secondOperand = inputTwo();
                        calcResult = (Math.log(secondOperand) / Math.log(firstOperand));
                        calcResult = numRound();
                        switchLoop = false;
                        break;
                    case 7: //Display Average
                        if (numOfCalculations == 0) {
                            System.out.println("\nError: No calculations yet to average! \n");
                            break;
                        }
                        System.out.println("Sum of calculations: " + totalNumbers);
                        System.out.println("Number of calculations: " + numOfCalculations);
                        System.out.println("Average of calculations: " + ((Math.round((totalNumbers / numOfCalculations) * 100.0)) / 100.0));
                        break;

                    default:
                        System.out.println("\nError: Invalid selection! \n");


                }

            }
            numOfCalculations++; //used in case 7 to display averages
        }
    }
}
