import java.util.Stack;

public class TowerOfHanoi {
    private Stack<Integer>[] rods;
    private int movesLeft;

    TowerOfHanoi(int n) {
        movesLeft = (int) (Math.pow(2, n) - 1);;
        rods = new Stack[3];
        rods[0] = new Stack<Integer>();
        for(int i = n; i >= 1; i--)
            rods[0].add(i);
        rods[1] = new Stack<Integer>();
        rods[2] = new Stack<Integer>();
    }

    public boolean legalMove(int a, int b) {
        if(rods[a].empty())
            return false;
        if(rods[b].empty())
            return true;
        return rods[a].peek() < rods[b].peek();
    }

    public boolean move(int a, int b) {
        if(!legalMove(a, b))
            return false;
        movesLeft--;
        int x = rods[a].pop();
        rods[b].add(x);

        System.out.println("disc "+x+" moved from rod "+a+" to rod "+b);
        showTowerStates();
        return true;
    }

    public boolean move(int m, int a, int b, int c) {
        int numMoves = (int) (Math.pow(2, m) - 1);
        if(m%2 == 1) {
            for(int i = 1; i <= numMoves; i++) {
                if(i%3 == 1) {
                    if(legalMove(a,b))
                        move(a,b);
                    else
                        move(b,a);
                }
                if(i%3 == 2) {
                    if(legalMove(a,c))
                        move(a,c);
                    else
                        move(c,a);
                }
                if(i%3 == 0) {
                    if(!legalMove(c,b))
                        move(b,c);
                    else
                        move(c,b);
                }
            }
        } else {
            for(int i = 1; i <= numMoves; i++) {
                if(i%3 == 1) {
                    if(!legalMove(a,c))
                        move(c,a);
                    else
                        move(a,c);
                }
                if(i%3 == 2) {
                    if(!legalMove(a,b))
                        move(b,a);
                    else
                        move(a,b);
                }
                if(i%3 == 0) {
                    if(!legalMove(c,b))
                        move(b,c);
                    else
                        move(c,b);
                }
            }
        }
        return true;
    }

    public void showTowerStates() {
        System.out.print("First Tower: ");
        for(int x : rods[0])
            System.out.print(x+" ");
        System.out.println();

        System.out.print("Second Tower: ");
        for(int x : rods[1])
            System.out.print(x+" ");
        System.out.println();

        System.out.print("Third Tower: ");
        for(int x : rods[2])
            System.out.print(x+" ");
        System.out.println();
    }

    public void solveGame() {
        move(rods[0].size(), 0, 2, 1);
    }

    public boolean gameLost() {
        return movesLeft > 0;
    }

    public boolean gameWon() {
        return (rods[0].isEmpty() && rods[1].isEmpty());
    }
}
