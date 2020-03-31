package com.KrzysztofBaka;

import java.util.List;
import java.util.Scanner;

public class Perceptron {
    List<List<String>> trainList = MyMethodes.readFile("Files/iris_training.txt");

    String nazwaDoTestow;
    Wagi tabWagi;

    int teta;
    double alfa = Math.random()*0.5;

    int counter=0;
    int s1=0;
    int s2=0;

    boolean start = true;

    public Perceptron(String nazwaDoTestow,int teta){
        this.teta=teta;
        this.nazwaDoTestow=nazwaDoTestow;
        tabWagi = new Wagi(trainList.get(0).size()-1);
        boolean start = true;

        do{
            szkolenie();
            if(s1!=s2){
                s2=s1;
            }else{
                start=false;
            }
            System.out.println(counter);
        }while (start);

    }

    public void szkolenie(){

        for (int i = 0; i < trainList.size(); i++) {
            double[] xtable = new double[trainList.get(i).size()];
            for (int j = 0; j < trainList.get(i).size()-1; j++) {
                xtable[j] = Double.valueOf(trainList.get(i).get(j));
            }

            double liczXwynik =0;
            for (int j = 0; j < tabWagi.tab_wagi.length; j++) {
                liczXwynik +=   xtable[j] * tabWagi.tab_wagi[j];
            }

            int statusNazwa;
            int statusPerceptron;

            if(trainList.get(i).get(trainList.get(i).size()-1).equals(nazwaDoTestow)){
                statusNazwa =1;
            }else{
                statusNazwa=0;
            }

            if(liczXwynik>=teta){
                statusPerceptron=1;
            }else{
                statusPerceptron=0;
            }

            boolean status=true;

            if(statusNazwa==1 && statusPerceptron==0){
                status=false;
            }else if(statusNazwa==0 && statusPerceptron==1){
                status=false;
            }

            String s = status==true ? "Okej" : "ZLE";
            System.out.println(trainList.get(i).get(trainList.get(i).size()-1)+
                    ", status nazwa: " +statusNazwa+
                    ", status perceptron: " + statusPerceptron+
                    ", wynik: " + status +
                    ", wynik obliczeń: " + liczXwynik);

            if(status==false){
                s1++;
                System.out.println("NOWE WAGI: ");
                for (int j = 0; j < tabWagi.tab_wagi.length; j++) {
                    tabWagi.tab_wagi[j] = tabWagi.tab_wagi[j] + (statusNazwa - statusPerceptron)*alfa*xtable[j];
                    System.out.print("x"+j + ": " + tabWagi.tab_wagi[j] + " ");
                }
                System.out.println("");
            }
        }
        counter++;
    }

    public void sprawdzenieListy(){
        List<List<String>> testList = MyMethodes.readFile("Files/iris_test.txt");
        int counter =0;

        for (int i = 0; i < testList.size(); i++) {
            double[] xtable = new double[trainList.get(i).size()];
            for (int j = 0; j < testList.get(i).size()-1; j++) {
                xtable[j] = Double.valueOf(testList.get(i).get(j));
            }

            double liczXwynik =0;
            for (int j = 0; j < tabWagi.tab_wagi.length; j++) {
                liczXwynik +=   xtable[j] * tabWagi.tab_wagi[j];
            }

            int statusPerceptron;

            if(liczXwynik>=teta){
                statusPerceptron=1;
                counter++;
            }else{
                statusPerceptron=0;
            }
            System.out.println(testList.get(i).get(testList.get(i).size()-1) + " status: "+statusPerceptron);
        }

        System.out.println("Znaleziono: " + counter + " " + nazwaDoTestow +"!");
    }

    public void sprawdzWpisane(){
        Scanner scanner1 = new Scanner(System.in);
        String check = scanner1.nextLine();
        System.out.println("================================");
        System.out.println("Wprowadź własne atrybuty: \nPrzykład: '6.3 2.9 5.6 1.8' \nNapisz 'end' by zakonczyc program");
        while(start){
            if(check.equals("end")){
                start=false;
                System.out.println("Koniec programu");
            }else{
                String[] s = check.split("\\s+");
                if(s.length==(tabWagi.tab_wagi.length)){

                    double liczXwynik =0;
                    for (int j = 0; j < tabWagi.tab_wagi.length; j++) {
                        liczXwynik +=   Double.parseDouble(s[j]) * tabWagi.tab_wagi[j];
                    }

                    int statusPerceptron;

                    if(liczXwynik>=teta){
                        statusPerceptron=1;
                    }else{
                        statusPerceptron=0;
                    }
                    String toShow = statusPerceptron==1 ? "Jest to "+nazwaDoTestow : "Jest to inny kwiatek!";
                    System.out.println(toShow);

                    check=scanner1.nextLine();

                }else{
                    System.out.println("Błędnie wpisane atrybuty!");
                    check=scanner1.nextLine();
                }
            }
        }
    }
}
