package com.ina.poc.threadsafety;

public class FinalTest {

    final String str
            = new String("hello");
    void method()
    {
        //str = "world";
    }
}

