package com.bkacad.nnt.calculatord02k11;

public final class Calculator {

    // Không cho phép tạo ra đối tượng Calculator
    private Calculator(){

    }

    public static double tong(double a, double b){
        return a + b;
    }
    public static double hieu(double a, double b){
        return  a - b;
    }
    public static double tich(double a, double b){
        return a * b;
    }
    public static double thuong(double a, double b) throws Exception{
        if(b == 0) {
            throw  new ArithmeticException("Không chia được cho 0");
        }
        return a/b;
    }
}
