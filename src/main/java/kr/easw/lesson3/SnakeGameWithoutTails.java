package kr.easw.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGameWithoutTails {

    private static final int BOARD_SIZE = 10;
    // 0 - �� Ÿ��
    // 1 - ������ũ ��
    // 2 - ������
    private static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    private static final Random RANDOM = new Random();

    private static int score = 0;

    private static SnakeLocation location = new SnakeLocation(0, 0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print("[���� (r) | ���� (l) | �� (u) | �Ʒ� (d) | ���� (0) ] : ");
            if (!nextDirection(scanner.next())) {
                System.out.println("���� ����!");
                System.out.printf("����: %d\n", score);
                break;
            }
            if (!hasItemOnBoard())
                placeRandomItem();
        }
    }

    /**
     * �ش� �޼���� ������ ���� ������ ������ �մϴ� :
     * ������� �Է��� �ް�, ���� ��ġ�� �ű�ų� ������ �����ؾ� �մϴ�.
     * <p>
     * ���Ǵ� �Է��� ������ �����ϴ� :
     * - ����(r) | ���� (l) | �� (u) | �Ʒ� (d) | ���� (0)
     * <p>
     * ���� ��ǥ�� location ������ ����ؼ� ������Ʈ�Ǿ�� �մϴ�.
     * ���� ���� ��ǥ�� �������� �����Ѵٸ�, ������ 1 �����ϰ� ���� ��ǥ�� ���� 0���� �ǵ����� �մϴ�.
     *
     * ���� ���� �ִ� �� (BOARD_SIZE)�̻��� �ǰų� �ּ� ��(0) �Ʒ��� �������ٸ� ���� ��ǥ�� �����Ͽ� �̵����� �ʵ��� �ؾ��մϴ�.
     *
     * ���� ������� �Է��� ����(0)���ٸ�, false���� ��ȯ�Ͽ� ������ �����ؾ� �մϴ�.
     */
    private static boolean nextDirection(String keyword) {
            switch (keyword) {
                case "r":
                    moveSnake(0, 1); // Move right
                    break;
                case "l":
                    moveSnake(0, -1); // Move left
                    break;
                case "u":
                    moveSnake(-1, 0); // Move up
                    break;
                case "d":
                    moveSnake(1, 0); // Move down
                    break;
                case "0":
                    return false; // End the game
                default:
                    System.out.println("�߸��� �Է��Դϴ�.");
            }
            return true;
        }

        private static void moveSnake(int dx, int dy) {
            int newX = location.getX() + dx;
            int newY = location.getY() + dy;

            // Check if new coordinates are out of bounds
            if (newX < 0 || newX >= BOARD_SIZE || newY < 0 || newY >= BOARD_SIZE) {
                return; // Don't move if out of bounds
            }

            // Update the snake's location
            location = new SnakeLocation(newX, newY);

            // Check if the new location has an item
            if (board[newX][newY] == 2) {
                score++; // Increase score
                board[newX][newY] = 0; // Remove the item from the board
            }
    }

    private static void printBoard() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (location.getX() == x && location.getY() == y) {
                    System.out.print("? ");
                    continue;
                }
                switch (board[x][y]) {
                    case 0:
                        System.out.print("? ");
                        break;
                    case 1:
                        System.out.print("?");
                        break;
                    case 2:
                        System.out.println("* ");
                        break;
                }
            }
            System.out.println();
        }
    }

    private static void placeRandomItem() {
        // for���� �������� ������ ���� ���, ��� ���Ͽ� ���� ������� �ٲ�Ƿ� ������ �����մϴ�.
        int toPlace = (int) (RANDOM.nextDouble() * 10);
        for (int i = 0; i < toPlace; i++) {
            int retry = 0;
            while (retry < 5) {
                SnakeLocation locate = new SnakeLocation((int)(RANDOM.nextDouble() * (BOARD_SIZE-1)), (int)(RANDOM.nextDouble() * (BOARD_SIZE-1)));
                if (board[locate.getX()][locate.getY()] != 0) {
                    retry++;
                    continue;
                }
                board[locate.getX()][locate.getY()] = 2;
                break;
            }
        }
    }

    private static boolean hasItemOnBoard() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class SnakeLocation {
        private final int x;
        private final int y;

        public SnakeLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public SnakeLocation adjust(int x, int y) {
            return new SnakeLocation(this.x + x, this.y + y);
        }
    }
}