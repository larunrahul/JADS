package com.learning.ads.misc;

import java.util.Arrays;

public class RotateMatrix{
    int[][] rotateImage(int[][] a) {
        rotate(a, 0, 0);
        return a;
    }
    
    void rotate(int[][] a, int i, int j){
        if(i == a.length / 2) return;
        int start = i, end = a.length - 1 - i;
        //for each row column except last one
        for(;start < end; start++){
            int row = i, column = start, substitute = a[row][column],element;
            row = row + (column - i); column = end;
            element = a[row][column];
            a[row][column] = substitute;
            substitute = element;
            column = end - (row - i); row = end; 
            element = a[row][column];
            a[row][column] = substitute;
            substitute = element;
            row = column; column = i; 
            element = a[row][column];
            a[row][column] = substitute;
            substitute = element;
            column = start; row = i; 
            a[row][column] = substitute;
        }
        rotate(a, i + 1, j + 1);
    }

    public static void main(String[] args) {

        int[][] a = {{10,9,6,3,7}, 
                     {6,10,2,9,7}, 
                     {7,6,3,8,2}, 
                     {8,9,7,9,9}, 
                     {6,8,6,8,2}};
        RotateMatrix rm = new RotateMatrix();
        rm.print(a);
        rm.print(rm.rotateImage(a));

    }

    void print(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
    
}