package com.gmail.nikolay.zinin;

public class Main {
    public static void main(String[] args) {
        new Main().go();
    }

    public  void go() {

        new ServerIO().talkToClient();
    }
}