package com.KrzysztofBaka;

public class Main {

    public static void main(String[] args) {
	Perceptron p = new Perceptron("Iris-setosa",1);

        System.out.println("-----------------------KONIEC-----------------------");
        System.out.println(p.wagi.x0);
        System.out.println(p.wagi.x1);
        System.out.println(p.wagi.x2);
        System.out.println(p.wagi.x3);
        p.sprawdzenieListy();

    }
}
