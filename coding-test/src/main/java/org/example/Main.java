package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i=0; i<nums.length; i++) {
            int maxIdx = i;
            for (int j=i; j<nums.length; j++) {
                if (nums[maxIdx] < nums[j]) {
                    maxIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIdx];
            nums[maxIdx] = temp;
        }

        for (int n : nums) {
            bw.write(String.valueOf(n));
        }
        bw.flush();
        br.close();
        bw.close();

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}