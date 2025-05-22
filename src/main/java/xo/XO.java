package xo;

import java.util.Scanner;

public class XO {

    public static void main(String[] args) {
        System.out.println("Welcome to XO!");
        Game xo = new Game();

        Scanner scanner = new Scanner(System.in);
        System.out.println(xo.getBoard());

        for (int turn = 0; turn < 9; turn++) {
            boolean player = turn % 2 == 0;
            String square;

            if (player) {
                System.out.print("You play: ");
                square = scanner.nextLine();
            } else {
                square = xo.computer.choose();
                System.out.println("The computer has played.");
            }
            int index = xo.play(square, player);

            System.out.println(xo.getBoard());

            if (turn > 3) {
                // We only check for a win 5 turns in and we only check the last played square
                if (!xo.checkWin(index)) continue;
                System.out.println("You " + (player ? "win." : "lose."));
                break;
            }
        }
        scanner.close();

        System.out.println("Goodbye.");
    }

}
