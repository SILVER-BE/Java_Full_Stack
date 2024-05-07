package com.ohgiraffers.section03.map.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /*
        * [ Map 인터페이스 특징 ]
        * Collection 인터페이스와는 다른 저장 방식을 가진다.
        * 키(key)와 값(value)를 하나의 쌍으로 저장하는 방식을 사용한다.
        *
        * 키(key)란?
        * 값(value)를 찾기 위한 이름 역할을 하는 객체를 의미한다.
        * 1. 요소의 저장 순서를 유지하지 않는다.
        * 2. 키는 중복을 허용하지 않지만, 키가 다르면 중복되는 값(value)은 저장 가능하다.
        *
        * HashMap, HashTable, TreeMap 등의 대표적인 클래스가 있다.
        * HashMap이 가장 많이 사용된다.
        * */

        //HashMap 인스턴스 생성
        HashMap hmap = new HashMap();

        hmap.put("one", new Date());
        //autoBoxing 처리 됨 : 12 -> new Interger(12)
        hmap.put(12, "red apple");
        hmap.put(33, 123);

        //저장 순서를 유지하지 않으나 키와 값이 쌍으로 묶여 출력
        System.out.println("hmap : " + hmap);

        //중복된 키값 삽입 -> 기존 red apple에 덮어씌워짐
        //키는 중복 저장되지 않음(set) : 최근 키로 override됨(덮어씀)
        hmap.put(12, "yellow banana");
        System.out.println("hmap : " + hmap);

        hmap.put(11, "yellow banana");
        hmap.put(9, "yellow banana");
        System.out.println("hmap : " + hmap);

        System.out.println("키 9에 대한 객체 : " + hmap.get(9));

        //키 값을 가지고 삭제를 처리할 때
        hmap.remove(9);
        System.out.println("hmap : " + hmap);

        //저장된 객체 수를 확인할 때
        System.out.println("hamp에 저장된 객체 수: " + hmap.size());

        System.out.println("----------------------------------------");

        HashMap<String, String> hmap2 = new HashMap<>();

        hmap2.put("one", "java 8");
        hmap2.put("two", "mysql");
        hmap2.put("three", "jdbc");
        hmap2.put("four", "html5");
        hmap2.put("five", "css3");

        // iterator() : Collection 인터페이스의 메소드로, Collection에 저장된 요소들을
        //              순차적으로 접근하는데 사용되는 Iterator를 반환한다.

        // 1. keySet()을 이용해서 키만 따로 set으로 만들고,           ★ set은 중복과 순서가 없다!
        //    iterator()로 키에 대한 목록을 만듦
        Iterator<String> keyIter = hmap2.keySet().iterator();

        while (keyIter.hasNext()) {
            String key = keyIter.next();      // next() : 한 칸 전진하면서 방금 지나친 목록의 데이터를 반환
            String value = hmap2.get(key);
            System.out.println(key + " = " + value); //순서는 저장되지 않는다. 출력은 무작위
        }

        // 2. 저장된 value 객체들만 values()로 Collection 을 만듦
        Collection<String> values = hmap2.values();

        System.out.println("[ 2-1 ] ------------------------- ");
        // 2-1. Iterator()로 목록을 만들어 처리
        Iterator<String> valueIter = values.iterator();
        while (valueIter.hasNext()) {
            System.out.println(valueIter.next());
        }

        System.out.println("[ 2-2 ] ------------------------- ");
        // 2-2. 배열로 만들어서 처리
        Object[] valueArr = values.toArray();
        for(int i = 0; i < valueArr.length; i++) {
            System.out.println(i + " : " + valueArr[i]);
        }

        System.out.println("[ 3 ] --------------------------- ");
        // 3. Map의 내부클래스인 EntrySet 을 이용
        Iterator<Map.Entry<String, String>> entryIter = hmap2.entrySet().iterator();
        while (entryIter.hasNext()) {
            Map.Entry<String, String> entry = entryIter.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        /* [ Entry ] : 키 객체와 값 객체를 쌍으로 묶은 것
        *  Entry는 java.util.Map 인터페이스의 내부 인터페이스로, Map안의 키-값 쌍을 나타낸다.
        *
        *  [ entrySet() ] : Map에 저장된 모든 키-값 쌍(Entry)를 Set 형태로 반환한다.
        *  getKey()와 getValue() 메소드를 제공하여 키와 값을 각각 가져올 수 있다.
        *
        *  [ Map.Entry ] :  객체는 하나의 키와 값에 대한 참조를 제공하며,
        *  이를 통해 특정 Map 항목의 키 or 값을 가져오거나 설정할 수 있다. */

//        Set<Map.Entry<String, String>> set = hmap2.entrySet();
//        Iterator<Map.Entry<String, String>> entryIter = set.iterator();

    }
}
