package com.ohgiraffers.section02.set.run;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        /*
        * [ TreeSet 클래스 ]
        * TreeSet 클래스는 데이터가 정렬된 상태로 저장되는 이진 검색 트리의 형태로 요소를 저장한다.
        * 이진 검색 트리는 데이터를 추가하거나 제거하는 등의 기본 동작 시간이 매우 빠르다.
        * JDK 1.2 부터 제공되고 있으며
        * Set 인터페이스가 가지는 특징을 그대로 가지지만 정렬된 상태를 유지한다는 것이 다른 점이다.
        * */

        TreeSet<String> tset = new TreeSet<>();
        Set<String> tset2 = new TreeSet<>();    //다형성 적용 가능

        tset.add("java");
        tset.add("oracle");
        tset.add("jdbc");
        tset.add("html");
        tset.add("css");
        System.out.println("tset : " + tset); //저절로 오름차순 정렬되어 출력

        //자동으로 String 타입으로 반환(제한)
        Iterator<String> iter = tset.iterator();

        //대문자로 출력 --> toUpperCase()
        while (iter.hasNext()) {
            System.out.println(iter.next().toUpperCase());
        }

        Object[] arr = tset.toArray();

        //toUpperCase는 String에만 동작, String으로 형변환
        for(Object obj : arr) {
            System.out.println(((String)obj).toUpperCase());
        }

        /* 로또 번호 발생(TreeSet 특징 이용) */

        Set<Integer> lotto = new TreeSet<>();

        //중복을 허용하지 않아 중복 없이 출력, 자동으로 배열 후 출력
        while(lotto.size() < 6) {
            lotto.add(((int)(Math.random() * 45)) + 1);
        }
        System.out.println("lotto : " + lotto);
    }
}
