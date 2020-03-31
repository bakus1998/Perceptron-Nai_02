package com.KrzysztofBaka;

public class Main {

    public static void main(String[] args) {
	Perceptron p = new Perceptron("Iris-setosa",1);

        System.out.println("-----------------------KONIEC-----------------------");
        p.sprawdzenieListy();
        System.out.println("================================");
        System.out.println("Wprowadź własne atrybuty: \nPrzykład: '6.3 2.9 5.6 1.8' \nNapisz 'end' by zakonczyc program");
        p.sprawdzWpisane();

    }
}
