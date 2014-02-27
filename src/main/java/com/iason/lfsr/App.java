package com.iason.lfsr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    static int N = 100;

    //(32,31,30,28,26,1) or (30,6,4,1.0) or (16,5,3.2,0)
    private static long primitivePolynomial(long s) {
        return ((((s >> 31) ^ (s >> 30) ^ (s >> 29) ^ (s >> 27) ^ (s >> 25) ^ s) & 1) << 31) | (s >> 1);
        //return ((((s >> 8) ^ (s >> 4) ^ (s >> 3) ^ (s >> 2)  ^ s) & 1) << 31) | (s >> 1);
        // return ((((s >> 2) ^ s) & 1) << 2) | (s >> 1);
    }

    static long[] LFSRandGenerateCompressing() {
        long res[] = new long[N];
        long s = 1;
        long s1, s2;
        int i = 0;
        while (i < N) {
            s1 = s & 1;
            s = primitivePolynomial(s);

            s2 = s & 1;
            if (s1 == 1) {
                res[i] = s2;
                i++;
            }
        }

//        long count = 1;
//        count = (count << 8)  - 1;
//
//        for ( int i = 1; i<count; ++i) {
//            result = (result << 1) + (s & 1);
//            s = primitivePolynomial(s);
//        }
//        count--;
//        List<Integer> sequence = new ArrayList<Integer>();
//        int s1 = (int) (result >> count--) % 2;
//        int s2 = (int) (result >> count--) % 2;
//
//        while (count >= -1) {
//            if (s1 == 1) {
//                sequence.add(s2);
//            }
//            s1 = s2;
//            s2 = (int) (result >> count--) % 2;
//        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(LFSRandGenerateCompressing());
    }
}
