package Week2.chomingi;

import java.util.*;
import java.io.*;

public class B1662 {
    static String line;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine();

        System.out.println(recur(0, line.length()-1));

    }

    static int recur(int start, int end){
        int temp = 0;
        // for (int i = start; i<=end; i++){
        //     System.out.print(line.charAt(i));
        // }
        // System.out.println();
        int open = -1;
        int close = -1;
        for (int i = start; i<=end; i++){

            if (line.charAt(i)=='(') open = i;
            if (line.charAt(i)==')'){
                temp 
                int K = line.charAt(open-1)-'0';
                int t = temp+K*recur(i+1, end-1);
                return t;
            }

        }
        return temp;
    }
}
