package model;

import java.util.*;

public class vModel extends Observable {
    private String data;
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public vModel(String data){
        this.data = data;
    }

    public void solve(String key){

    }

    public String getData(){
        return data;
    }

    private boolean checkAlpha(String s){

        return true;
    }


}
