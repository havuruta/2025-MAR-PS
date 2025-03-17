package Week2.chomingi;

import java.util.*;
import java.io.*;

public class B2263 {
    static int n;
    static int[] inOrder, postOrder, inOrderIdx;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inOrderIdx = new int[n+1];
        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i<n; i++) inOrderIdx[inOrder[i]]=i;
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        makePreOrder(0, n-1, 0, n-1);
        System.out.println(sb.toString());
        
    }

    // 하 완전이진트리인줄.. 왜 두개를 주나 싶었네
    static void makePreOrder(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd){
        // 접근은 맞았지만 해당 조건 분기를 생각을 못함
        if (inOrderEnd<inOrderStart || postOrderEnd<postOrderStart) return;
        int rootNode = postOrder[postOrderEnd];
        sb.append(rootNode).append(" ");

        int rootIdx = inOrderIdx[rootNode];
        int leftTreeSize = rootIdx-inOrderStart;

        // left
        makePreOrder(inOrderStart, rootIdx-1, postOrderStart, postOrderStart+leftTreeSize-1);
        // right
        makePreOrder(rootIdx+1, inOrderEnd, postOrderStart+leftTreeSize, postOrderEnd-1);
    }
}
