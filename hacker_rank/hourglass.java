//Problem: https://www.hackerrank.com/challenges/java-2d-array
//You are given a 6x6 2D array. An hourglass in an array is a portion shaped like this:
//
// a b c
//   d
// e f g
// For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:
//
// 1 1 1 0 0 0
// 0 1 0 0 0 0
// 1 1 1 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:
//
// 1 1 1     1 1 0     1 0 0
//   1         0         0
// 1 1 1     1 1 0     1 0 0
// The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.
//
// In this problem you have to print the largest sum among all the hourglasses in the array.


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    //collect the sum of each hour glass and then pick the largest one

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int sumArray[] = new int[15];
        int sumCount = 0;
        int sum = Integer.MIN_VALUE;

            for(int k =0; k <= 3; k++) {
                for (int l = 0; l <= 3; l++) {
                    int sum1 = arr[k][l + 1] + arr[k][l] + arr[k][l + 2] + arr[k + 1][l + 1] + arr[k + 2][l] + arr[k + 2][l + 1] + arr[k + 2][l + 2];
                    if (sum1 > sum) {
                        sum = sum1;
                    }
                }
            }

        System.out.println(sum);
    }
