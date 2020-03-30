package com.KrzysztofBaka;

import java.util.ArrayList;
import java.util.List;

public class Perceptron {
    List<Double> lwagi = new ArrayList<>();
    List<List<String>> trainList = MyMethodes.readFile(trainPath);
    Wagi tabWagi = new Wagi(trainList.get(0).size()-1);
    int teta;
    String nazwaDoTestow;
    double alfa = Math.random()*0.5;
    static String testPath = "Files/iris_test.txt";
    Wagi wagi;
    static String trainPath = "G:\\Studia\\NAI\\Projekt 2\\src\\Files\\iris_training.txt";

    int counter=0;
    int s1=0;
    int s2=0;

    public Perceptron(String nazwaDoTestow,int teta){
        this.teta=teta;
        this.nazwaDoTestow=nazwaDoTestow;
        wagi = new Wagi(0,0,0,0);
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
       // System.out.println(trainList);
        //System.out.println("======================================================================================");

        for (int i = 0; i < trainList.size(); i++) {
            Double x0 = Double.valueOf(trainList.get(i).get(0));
            Double x1 = Double.valueOf(trainList.get(i).get(1));
            Double x2 = Double.valueOf(trainList.get(i).get(2));
            Double x3 = Double.valueOf(trainList.get(i).get(3));
            double[] xtable = new double[trainList.get(i).size()];
            System.out.println("TO JEST XTABLE");
            for (int j = 0; j < trainList.get(i).size()-1; j++) {
                xtable[j] = Double.valueOf(trainList.get(i).get(j));
            }


            //System.out.println("x0: " + x0 + ", x1: " + x1 + ", x2: " + x2+ ", x3: " + x3);

            double liczXwynik =0;
            for (int j = 0; j < tabWagi.tab_wagi.length; j++) {
                liczXwynik +=   xtable[j] * tabWagi.tab_wagi[j];
            }

            Double liczX = x0 * wagi.x0 + x1 * wagi.x1 + x2 * wagi.x2 + x3 * wagi.x3;

            System.out.println(liczX + " " + liczXwynik);
            //System.out.println("liczX: " + liczX);
            int statusNazwa;
            int statusPerceptron;

            if(trainList.get(i).get(trainList.get(i).size()-1).equals(nazwaDoTestow)){
                statusNazwa =1;
            }else{
                statusNazwa=0;
            }

            if(liczX>=teta){
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
           // System.out.println("Status nazwa: " + statusNazwa + ", status Perceptron " + s);

            if(status==false){
                s1++;
                wagi.x0 = wagi.x0 + (statusNazwa - statusPerceptron)* alfa * x0;
                wagi.x1 = wagi.x1 + (statusNazwa - statusPerceptron)* alfa * x1;
                wagi.x2 = wagi.x2 + (statusNazwa - statusPerceptron)* alfa * x2;
                wagi.x3 = wagi.x3 + (statusNazwa - statusPerceptron)* alfa * x3;
                for (int j = 0; j < tabWagi.tab_wagi.length; j++) {
                    tabWagi.tab_wagi[j] = tabWagi.tab_wagi[j] + (statusNazwa - statusPerceptron)*alfa*xtable[j];
                }
                System.out.println("NOWE WAGI x0: " + wagi.x0 + ", x1: " + wagi.x1 + ", x2: " + wagi.x2+ ", x3: " + wagi.x3);
                System.out.println("NOWE WAGI x0: " + tabWagi.tab_wagi[0] + ", x1: " + tabWagi.tab_wagi[1] + ", x2: " + tabWagi.tab_wagi[2]+ ", x3: " + tabWagi.tab_wagi[3]);
            }
        }
        counter++;
    }

    public void sprawdzenieListy(){
        List<List<String>> testList = MyMethodes.readFile("G:\\Studia\\NAI\\Projekt 2\\src\\Files\\iris_test.txt");

        for (int i = 0; i < testList.size(); i++) {
            Double x0 = Double.valueOf(testList.get(i).get(0));
            Double x1 = Double.valueOf(testList.get(i).get(1));
            Double x2 = Double.valueOf(testList.get(i).get(2));
            Double x3 = Double.valueOf(testList.get(i).get(3));

            Double liczX = x0 * wagi.x0 + x1 * wagi.x1 + x2 * wagi.x2 + x3 * wagi.x3;
            int statusPerceptron;

            if(liczX>=teta){
                statusPerceptron=1;
            }else{
                statusPerceptron=0;
            }

            System.out.println(testList.get(i).get(testList.get(i).size()-1) + " status: "+statusPerceptron);
        }
    }

}
