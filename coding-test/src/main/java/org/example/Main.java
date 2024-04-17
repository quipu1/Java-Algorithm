package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();
        int[] acgt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cntAcgt = new int[4];

        for (int i=0; i<P; i++) {
            switch (str[i]) {
                case 'A': cntAcgt[0]++; break;
                case 'C': cntAcgt[1]++; break;
                case 'G': cntAcgt[2]++; break;
                case 'T': cntAcgt[3]++; break;
            }
        }

        int cnt = 0;
        for (int b = P-1; b<S; b++) {
            int a = b - P + 1;

            if (acgt[0] <= cntAcgt[0] && acgt[1] <= cntAcgt[1] && acgt[2] <= cntAcgt[2] && acgt[3] <= cntAcgt[3]) {
                cnt++;
            }

            if (b == S-1) break;

            switch (str[a]) {
                case 'A': cntAcgt[0]--; break;
                case 'C': cntAcgt[1]--; break;
                case 'G': cntAcgt[2]--; break;
                case 'T': cntAcgt[3]--; break;
            }

            switch (str[b + 1]) {
                case 'A': cntAcgt[0]++; break;
                case 'C': cntAcgt[1]++; break;
                case 'G': cntAcgt[2]++; break;
                case 'T': cntAcgt[3]++; break;
            }
        }


        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}