package com.ohgiraffers.section01.method;

public class Calculator {

    public int minNumberof(int first, int second) {
        return (first > second)? second : first;
    }

    public static  int maxNumberof(int first, int second) {
        return (first > second)? first : second;
    }
}
