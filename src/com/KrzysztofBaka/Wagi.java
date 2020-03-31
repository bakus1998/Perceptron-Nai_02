package com.KrzysztofBaka;

public class Wagi {
    double[] tab_wagi;


    public Wagi(int size){
        tab_wagi = new double[size];
        for (int i = 0; i < tab_wagi.length; i++) {
            tab_wagi[i]=0;
        }
    }

}
