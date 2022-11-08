package tech.sylardaemon.offer;

import java.util.Arrays;

public class Solution60 {
    public double[] dicesProbability(int n) {
        double[] crabs = new double[6];
        Arrays.fill(crabs, 1.0 / 6.0);
        for (int i = 2; i <= n; ++i){
            double[] next_crabs = new double[i * 5 + 1];
            for (int j = 0; j < crabs.length; ++j){
                for (int k = 0; k < 6; ++k){
                    next_crabs[j + k] += crabs[j] / 6.0;
                }
            }
            crabs = next_crabs;
        }
        return crabs;
    }
}
