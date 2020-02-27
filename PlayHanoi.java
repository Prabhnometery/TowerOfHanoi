import java.util.Scanner;

public class PlayHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size [1 - 6]: ");
        int n = 0;
        while(true) {
            n = Integer.parseInt(scanner.nextLine());
            if(n >= 1 && n <= 6)
                break;
            System.out.println("Invalid size, try again");
        }

        TowerOfHanoi game = new TowerOfHanoi(n);

        System.out.println("Do you want to Play? (Y/N)");
        String s = scanner.nextLine();
        if(s.equals("Y")) {
            while(!game.gameLost() && !game.gameWon()) {
                System.out.println("Enter move:");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if(game.legalMove(a, b))
                    game.move(a, b);
                else
                    System.out.println("Illegal move");
            }
            if(game.gameWon())
                System.out.println("Well done! You won!");
            else
                System.out.println("You Loose!");
        } else {
            System.out.println("Display Demo: ");
            game.showTowerStates();
            game.solveGame();
        }
    }


}