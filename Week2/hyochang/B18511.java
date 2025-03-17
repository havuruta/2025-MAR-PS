package Week2.hyochang;

import java.util.*;
import java.io.*;

public class B18511 {
    // 18511 - 큰 수 구성하기
    // n보다 작은 수 + k개의 원소로 만듬

    static int n, k;
    static int[] arr;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        find(0);
        System.out.println(ans);

    }

    static void find(int num) {
        if (num > n) {//n보다 크면 탐색 x
            return;
        }
        ans = Math.max(ans, num);
        for (int i = 0; i < k; i++) {
            find(num * 10 + arr[i]);
        }
    }
}