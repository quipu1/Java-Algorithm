package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int now = 0;
        StringBuilder ans = new StringBuilder();

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (now < num) {
                for (int j=now+1; j<=num; j++) {
                    stack.push(j);
                    ans = ans.append("+\n");
                }
                now = num;
            }

            if (stack.pop().equals(num)) {
                ans = ans.append("-\n");
            } else {
                ans.replace(0, ans.length(),"NO");
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}