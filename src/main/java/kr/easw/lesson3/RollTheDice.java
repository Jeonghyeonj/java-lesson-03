package kr.easw.lesson3;

import java.util.Arrays;
import java.util.Random;

public class RollTheDice {
    private static int[] frequency = new int[6];

    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 600; i++) {
            if (RANDOM.nextDouble() < 0.1) {
                fillArray(RANDOM.nextDouble() * 720);
            } else {
                fillArray(RANDOM.nextDouble() * 360);
            }
        }
    }

    /**
     * �ش� �޼���� ������ ���� ������ ������ �մϴ� :
     * �־��� ���� 60���� ���� ��, ���� ���� ����ŭ �ش� �ε����� �����ϴ� �迭 ���� 1 �������Ѿ� �մϴ�.
     * ����, ��� ��쿡���� �־��� ����� �������� ��, ������ �߻��ؼ��� �ȵ˴ϴ�.
     * <p>
     * �Է°��� �Ϲ������δ� 360�� ���� ������, ���� Ȯ���� 360�� �ѽ��ϴ�.
     * �̷��� ���, extendArray �޼��带 �����Ͽ� �̸� �̿��� �迭�� �缱���ؾ� �մϴ�.
     *
     * ����, �Է°��� double������ 60���� ���� ���� int�� ĳ������ �ʿ��մϴ�.
     */
    private static void fillArray(double result) {
        if (result<360) {int index= (int) (result/60);
    frequency[index]++;}
    }

    /**
     * �ش� �޼���� ������ ���� ������ ������ �մϴ� :
     * �־��� ���� ũ�⸸ŭ �迭�� ������ ��, ���� �迭�� �ִ� �����͸� ������ ��ȯ�ؾ� �մϴ�.
     */
    private static int[] extendArray(int next) {
        int[] newArray= Arrays.copyOf(frequency,next);
        frequency=newArray;
        return newArray;
    }
}