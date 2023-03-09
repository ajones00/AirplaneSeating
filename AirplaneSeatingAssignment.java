import java.util.Arrays;
import java.util.Scanner;

public class AirplaneSeatingAssignment {
    public static void main(String[] args) {
        boolean[][] seats;
        seats = initializeSeats();
        showMenu(seats);
    }

    public static boolean[][] initializeSeats() {
        boolean[][] arr = new boolean[13][6];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], false);
        }
        return arr;
    }

    public static void showMenu(boolean[][] arr) {
        boolean flag = false;
        while (!flag) {
            System.out.println("This program assigns seats for a commercial airplane.\n" +
                    "The current seat assignments is as follows.");
            showSeats(arr);
            System.out.println("Rows 1 and 2 are for first class passengers.\n" +
                    "Rows 3 through 7 are for business class passengers.\n" +
                    "Rows 8 through 13 are for economy class passengers");
            System.out.println("To reserve a seat enter Y/y(Yes), N/n(No):");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine();

            while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("To reserve a seat enter Y/y(Yes), N/n(No):");
                input = userInput.nextLine();
            }

            if (input.equalsIgnoreCase("Y")) {
                String ticketType;
                System.out.print("\nEnter ticket type: F/f (first class);  " +
                        "(B/b) (business class); E/e (economy class): ");
                ticketType = userInput.nextLine();

                while (!ticketType.equalsIgnoreCase("F") && !ticketType.equalsIgnoreCase("B")
                        && !ticketType.equalsIgnoreCase("E")) {
                    System.out.print("\nEnter ticket type: F/f (first class); " +
                            "(B/b) (business class); E/e (economy class): ");
                    ticketType = userInput.nextLine();
                }

                int rowNum;
                int seatNum;
                char seatNumChar;

                if (ticketType.equalsIgnoreCase("F")) {
                    System.out.print("\nEnter Row number 1 - 2: ");
                    rowNum = userInput.nextInt();
                    while (rowNum > 2 || rowNum < 1) {
                        System.out.print("\nEnter Row number 1 - 2: ");
                        rowNum = userInput.nextInt();
                    }
                    userInput.nextLine();
                } else if (ticketType.equalsIgnoreCase("B")) {
                    System.out.print("\nEnter Row number 3 - 7: ");
                    rowNum = userInput.nextInt();
                    while (rowNum > 7 || rowNum < 3) {
                        System.out.print("\nEnter Row number 3 - 7: ");
                        rowNum = userInput.nextInt();
                    }
                    userInput.nextLine();
                } else {
                    System.out.print("\nEnter Row number 8 - 13: ");
                    rowNum = userInput.nextInt();
                    while (rowNum > 13 || rowNum < 8) {
                        System.out.print("\nEnter Row number 8 - 13: ");
                        rowNum = userInput.nextInt();
                    }
                    userInput.nextLine();
                }

                System.out.print("\nEnter seat letter (A - F): ");
                seatNumChar = userInput.next().toUpperCase().charAt(0);
                while (seatNumChar < 65 || seatNumChar > 70) {
                    System.out.print("\nEnter seat letter (A - F): ");
                    seatNumChar = userInput.next().toUpperCase().charAt(0);
                }
                seatNum = seatNumChar - 65;

                while (getSeat(rowNum, seatNum, arr)) {
                    System.out.println("*#*#*#*# This seat is occupied *#*#*#*#\n" +
                            "Make another selection");
                    showSeats(arr);
                    if (ticketType.equalsIgnoreCase("F")) {
                        System.out.print("\nEnter Row number 1 - 2: ");
                        rowNum = userInput.nextInt();
                        while (rowNum > 2 || rowNum < 1) {
                            System.out.print("\nEnter Row number 1 - 2: ");
                            rowNum = userInput.nextInt();
                        }
                        userInput.nextLine();
                    } else if (ticketType.equalsIgnoreCase("B")) {
                        System.out.print("\nEnter Row number 3 - 7: ");
                        rowNum = userInput.nextInt();
                        while (rowNum > 7 || rowNum < 3) {
                            System.out.print("\nEnter Row number 3 - 7: ");
                            rowNum = userInput.nextInt();
                        }
                        userInput.nextLine();
                    } else {
                        System.out.print("\nEnter Row number 8 - 13: ");
                        rowNum = userInput.nextInt();
                        while (rowNum > 13 || rowNum < 8) {
                            System.out.print("\nEnter Row number 8 - 13: ");
                            rowNum = userInput.nextInt();
                        }
                        userInput.nextLine();
                    }

                    System.out.print("\nEnter seat letter (A - F): ");
                    seatNumChar = userInput.next().toUpperCase().charAt(0);
                    while (seatNumChar < 65 || seatNumChar > 70) {
                        System.out.print("\nEnter seat letter (A - F): ");
                        seatNumChar = userInput.next().toUpperCase().charAt(0);
                    }
                    seatNum = seatNumChar - 65;
                }
                assignSeat(rowNum, seatNum, arr);
            } else {
                flag = true;
            }
        }
    }

    public static boolean getSeat(int rowNum, int seatNum, boolean[][] arr) {
        return arr[rowNum - 1][seatNum];
    }

    public static void assignSeat(int rowNum, int seatNum, boolean[][] arr) {
        arr[rowNum - 1][seatNum] = true;
        System.out.println("\nThis seat is reserved for you");
        showSeats(arr);
    }

    public static void showSeats(boolean[][] arr) {
        System.out.println("        A B C D E F");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-8s", "Row " + (i + 1));
            for (int j = 0; j < arr[i].length; j++) {
                if (!arr[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println("* -- available seat\nX -- occupied seat\n");
    }
}