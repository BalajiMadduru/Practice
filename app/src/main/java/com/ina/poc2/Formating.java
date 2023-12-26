package com.ina.poc2;

public class Formating {

public static void main(String args[]){

    // properties

    String firstname = "klaus";
    String lastname = "mikelson";
    int firstvalue = 10;
    int secondvalue =20;
    float point = 6.5f;
    double dblvalue = 12.34;

    //performing String  operations

    System.out.println(String.format("name is %2$s %n %1$s :",firstname,lastname));  // mikelson klaus

    System.out.println(String.format("name is %2$s %n %1$S :",firstname,lastname)); // mikelson KLAUS

    System.out.println(String.format("name is %21s %n %1S :",firstname,lastname)); // klaus        MIKELSON

    System.out.println(String.format("first value is %d",firstvalue));  // 10

    System.out.println(String.format("second value is %s",secondvalue)) ;// 20

    System.out.println(String.format("%+d",firstvalue));  //10

    System.out.println(String.format("%f" ,point)) ;    // 6.5

    System.out.println(String.format("%f",dblvalue));  // 12.34

    System.out.println(String.format("%07d",secondvalue));  // 0000020


}
}
