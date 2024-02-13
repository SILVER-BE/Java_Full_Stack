package com.eunbi.practice.qqq;

public class array1 {
    public static void main(String[] args) {

        int[] arr = new int[6];

        // 난수 발생

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 45) + 1;
            for(int j = i - 0; j < i; i++) {
                arr[j] = (int)(Math.random() * 45) + 1;
                if(arr[i] == arr[j]) {
                    i--;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmep = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmep;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
