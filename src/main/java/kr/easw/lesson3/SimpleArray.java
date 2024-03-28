package kr.easw.lesson3;

import java.util.Arrays;

public class SimpleArray {
    private static int[] arrays = new int[10];

    private static int[] answer = new int[]{0, 1, 4, 16, 25, 49, 64, 81, 121, 144};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            fillArray(i);
        }
        boolean isMatched = true;
        for (int i = 0; i < 10; i++) {
            if (arrays[i] != answer[i]) {
                System.out.printf("���� �������� �ʽ��ϴ�. (�ε��� %d)\n", i);
                isMatched = false;
            }
        }
        if (isMatched) {
            System.out.println("�����Դϴ�.");
        } else {
            System.out.println("�����Դϴ�.");
        }
    }

    /**
     * �ش� �޼���� ������ ���� ������ ������ �մϴ� :
     * �־��� �ε����� �̿��Ͽ� array ������ ���� ������ �����Ͽ� �߰��ؾ� �մϴ�.
     * <p>
     * (index x 7 / 5) ^ 2
     * <p>
     * * ^2�� ������ �ǹ̷� ���Ǿ����ϴ�.
     */
    private static void fillArray(int index) {
            arrays[index] = (int) Math.pow((index * 7 / 5), 2);
        }
}