package com.company;

import com.sun.jdi.event.MethodExitEvent;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String a, b;
        String action;
        int par_1 = 0, par_2 = 0, res = 0;
        boolean status = false;

        Scanner console = new Scanner(System.in);
        a = console.next();
        action = console.next();
        b = console.next();

        if (isDigit(a) && isDigit(b)) {
            par_1 = Integer.parseInt(a);
            par_2 = Integer.parseInt(b);
        }
        else if(isDigit(a) != isDigit(b) ) System.exit(0);
        else {
            par_1=RomanNumber.toArab(a);
            par_2=RomanNumber.toArab(b);
            status=true;
        }



        switch (action) {
            case "+":
                res = (par_1 + par_2);
                break;
            case "-":
                res = (par_1 - par_2);
                break;
            case "*":
                res = (par_1 * par_2);
                break;
            case "/":
                res = (par_1 / par_2);
                break;
        }
        if(status)System.out.println(RomanNumber.toRoman(res));
        else System.out.println(res);
    }

    public static class RomanNumber {

        private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        static {

            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");

        }

        public static String toRoman(int number) {
            int l = map.floorKey(number);
            if (number == l) {
                return map.get(number);
            }
            return map.get(l) + toRoman(number - l);
        }

        public static int toArab(String number) {
            int i=0;
            do i++; while(toRoman(i).equals(number) == false);
            return i;
        }
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
