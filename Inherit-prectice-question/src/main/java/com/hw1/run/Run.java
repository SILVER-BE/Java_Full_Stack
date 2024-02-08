package com.hw1.run;
import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Person;
import com.hw1.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

//        // 3명의 학생 정보를 기록할 수 있게 객체 배열 할당
//        Person[] person = new Person[3];
//
//        // 위의 사용데이터 참고하여 3명의 학생 정보 초기화
//        person[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
//        person[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
//        person[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
//
//        // 위의 학생 정보 모두 출력 -> 향상된 for문 이용
//        for(Person r : person) {
//            System.out.println(r.getInformation());
//        }

        /* ---------------------------------------------------------------------- */

        Employee employee = new Employee();

        // 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
        Employee[] person2 = new Employee[10];

        // 사원들의 정보를 키보드로 계속 입력 받고 -> while(true) 무한 반복문을 통해
        Scanner sc = new Scanner(System.in);

        int i = 0;

        while(true) {

            System.out.print("이름를 입력하세요 : ");
            String name = sc.nextLine();

            System.out.print("나이를 입력하세요 : ");
            int age = sc.nextInt();

            System.out.print("키를 입력하세요 : ");
            double height = sc.nextDouble();

            sc.nextLine();

            System.out.print("몸무게를 입력하세요 : ");
            double weight = sc.nextDouble();

            sc.nextLine();

            System.out.print("급여를 입력하세요 : ");
            int salary = sc.nextInt();

            sc.nextLine();

            System.out.print("부서를 입력하세요 : ");
            String dept = sc.nextLine();

            person2[i] = new Employee(name, age, height, weight, salary, dept);

            i++;

            System.out.println("[ 총 " + i + " 명 입력됨 ]");

            System.out.print("계속 추가하시겠습니까? : ");
            String answer2 = sc.nextLine();
            String answer1 = "y";

            if(!answer2.equals(answer1)) {
                break;
            }
        }

        for(int j = 0; j < i; j++) {
            System.out.println(person2[j].getInformation());
        }
    }

}