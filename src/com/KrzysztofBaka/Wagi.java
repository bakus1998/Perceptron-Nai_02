package com.KrzysztofBaka;

import java.util.ArrayList;
import java.util.List;

public class Wagi {
    double x0;
    double x1;
    double x2;
    double x3;
    List<Double> wagi = new ArrayList<>();
    double[] tab_wagi;

    public Wagi(double x0,double x1,double x2,double x3){
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        System.out.println("Wagi x0: " + x0 + ", x1: " + x1 + ", x2: " + x2+ ", x3: " + x3);
    }

    public Wagi(int size){
        tab_wagi = new double[size];
        for (int i = 0; i < tab_wagi.length; i++) {
            tab_wagi[i]=0;
        }
    }

    public void setWagi(double x0,double x1,double x2,double x3){
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }


    @Override
    public String toString() {
        return "Wagi x0: " + x0 + ", x1: " + x1 + ", x2: " + x2+ ", x3: " + x3;
    }
}
