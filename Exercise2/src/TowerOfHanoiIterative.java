import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoiIterative {

    static class Move {
        int n;
        char source, destination, auxiliary;

        Move(int n, char source, char destination, char auxiliary) {
            this.n = n;
            this.source = source;
            this.destination = destination;
            this.auxiliary = auxiliary;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of disks: ");
        int numberOfDisks = scanner.nextInt();

        towerOfHanoiIterative(numberOfDisks);

        scanner.close();
    }

    public static void towerOfHanoiIterative(int n) {
        Stack<Move> stack = new Stack<>();
        stack.push(new Move(n, 'A', 'C', 'B'));

        while (!stack.isEmpty()) {
            Move currentMove = stack.pop();

            if (currentMove.n == 1) {
                System.out.println("Move disk 1 from " + currentMove.source + " to " + currentMove.destination);
            } else {
                stack.push(new Move(currentMove.n - 1, currentMove.auxiliary, currentMove.destination, currentMove.source));
                stack.push(new Move(1, currentMove.source, currentMove.destination, currentMove.auxiliary));
                stack.push(new Move(currentMove.n - 1, currentMove.source, currentMove.auxiliary, currentMove.destination));
            }
        }
    }
}