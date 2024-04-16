package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 1;    //자기 자신일때 먼저 카운트 해둠
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while (endIdx != n) {
            if (sum < n) {
                endIdx++;
                sum = sum + endIdx;
            } else if (sum == n) {
                ans ++;
                endIdx++;
                sum = sum + endIdx;
            } else {
                sum = sum - startIdx;
                startIdx++;
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