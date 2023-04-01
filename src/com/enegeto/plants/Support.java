package com.enegeto.plants;


    import java.util.Scanner;

    public class Support {

        private static Scanner scanner = null;
        private static Scanner getScanner() {
            if (scanner == null) {
                scanner = new Scanner(System.in);
            }
            return scanner;
        }

        public static int INVALID_INPUT = -1;

        /**
         * Read one integer. If given input cannot be converted to integer,
         * prints error and return -1;
         * @return Integer read or -1 if invalid input entered
         */
        public static int safeReadInt() {
            int result = INVALID_INPUT;
            String inputText = getScanner().nextLine();
            try {
                result = Integer.parseInt(inputText);
            } catch (NumberFormatException ex) {
                System.err.println("You have entered text that is not possible convert into an integer: "+inputText);
            }
            return result;
        }


        /**
         * Read out keyboard to get the position of item given by user
         * Uses the safeReadInt method
         * Number -1 ends the method
         * @return Integer read
         */
        public static int keyboardRead(PlantList plantList) {
            int input = 0;
            do {
                System.out.print("Please enter the position you want to read out (-1 ends the program): ");
                input = Support.safeReadInt();
                if (input == -1) {
                    System.out.println("You ended the program (result is automatically set for the first plant in the list)");
                    return 0;
                }
                if (input < 0 && input != -1) System.err.println("You entered a negative number, try again!");
                if (input > (plantList.getSize()-1)) {
                    System.err.println("The number is higher than number of plants in your list, try again!");
                }
            } while ((input != -1 && input < 0) || input >= plantList.getSize());
            return input;
        }





}
