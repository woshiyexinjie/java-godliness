package com.helloxin.lang;

/**
 * Created by nandiexin on 2018/2/3.
 */

    interface Extendbroadable {

        public void inPut();

    public void inPut2();


    }


    class KeyBoard implements Extendbroadable {

        @Override
        public void inPut() {

            System.out.println("\n hi, keybroad has be input into then mainbroad!\n");

        }

        @Override
        public void inPut2() {

        }

    }
    class NetCarBroad implements Extendbroadable {

        @Override
        public void inPut() {

            System.out.println("\n hi, NetCarBroad has be input into then mainbroad!\n");

        }

        @Override
        public void inPut2() {

        }

    }


    class CheckBroad {

        public void getMainMessage(Extendbroadable ext) {

            ext.inPut();

        }

    }


    public class InterfaceTest01 {

        public static void main(String [] args) {

            KeyBoard kb = new KeyBoard();

            NetCarBroad ncb = new NetCarBroad();

            CheckBroad cb = new CheckBroad();

            cb.getMainMessage(kb);

            cb.getMainMessage(ncb);

        }

    }

