package org.example.ch3.ex3_2;

class Parent2 {
    int i = 7;
    public int get() {
        return i;
    }
}

/**
 * Child2 클래스가 new 키워드로 객체로 생성된다면, 힙 메모리에는 Child2 클래스 멤버변수인 i 와 부모클래스 Parent2 클래스 멤버변수 i 가 모두 올라간다.
 * 리턴타입(참조형)이 Child2 인 경우는 Child2 의 클래스멤버변수를 , Parent2 인 경우는 Parent2 의 클래스멤버변수를 사용함.
 */
class Child2 extends Parent2 {
    int i = 5;
    public int get() {
        return i;
    }
}

public class ChildTest {
    public static void print(Parent2 p) {
        System.out.println(p.i);
        System.out.println(p.get());
    }

    public static void main(String[] args) {
        Parent2 p = new Parent2();
        System.out.println("---------- 1 ----------");
        System.out.println(p.i);
        System.out.println(p.get());

        Child2 c = new Child2();
        System.out.println("---------- 2 ----------");
        System.out.println(c.i);
        System.out.println(c.get());

        Parent2 p2 = new Child2();
        System.out.println("---------- 3 ----------");
        System.out.println(p2.i);
        System.out.println(p2.get());

        System.out.println("---------- 4 ----------");
        print(c);
        print(p2);
    }
}
