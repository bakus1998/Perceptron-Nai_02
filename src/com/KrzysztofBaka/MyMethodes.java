package com.KrzysztofBaka;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyMethodes {
    static int size;

    public static List readFile(String path){
        File file;
        List<List<String>> myList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    List<String> st = new ArrayList<>();
                    String[] toSplit = s.split("\\s+");
                    size = toSplit.length-1;

                    for (int i = 1; i < toSplit.length; i++) {
                        String replacer = toSplit[i].replace(",",".");
                        //System.out.println(replacer);
                        st.add(replacer);
                    }
                    myList.add(st);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }catch (FileNotFoundException e){
            System.err.println("Nieprawidłowa ścieżka pliku!");
        }
        return myList;
    }

    public static void showList(List<List<String>> myList){
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).toString());
        }
    }
}
